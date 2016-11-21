package com.sedi.groovy

import com.sedi.constant.MessageStatus
import com.sedi.constant.Utils
import com.sedi.entity.MessageEntity
import groovy.xml.MarkupBuilder
import org.apache.log4j.Logger

/**
 * Created by csw on 2015/11/4.
 */
class SendJCJGMT9901 {

    private static Logger logger = Logger.getLogger(SendJCJGMT9901.class)

    private String fileDir = "D:\\message\\进出监管场所报文"
    private String fileDirBak = "D:\\message\\backup\\进出监管场所报文"

    private String messageId
    private String messageType
    private String sendId
    private String receiveId
    private String barrierNum
    private String sendTime

    public MessageEntity message = new MessageEntity()

    public String execute(Map<String, Object> param) {

        logger.info("进出监管场所:开始生成进出监管场所报文")
        try{
            this.createXmlDefaultInfo() //初始默认信息
            String xmlStr = null
            if(param.get("xmlStr") != null) {
                xmlStr = param.get("xmlStr")
            }else {
                xmlStr = this.createXmlStr(param)
            }
            File xmlFile = this.generateXmlFile(xmlStr)
            if(xmlFile != null) {
                logger.info("进出监管场所:"+messageId+"报文生成成功")
                if(this.sendFile(xmlFile)) {
                    logger.info("进出监管场所:"+messageId+"报文发送成功")
                    message.setStatus(MessageStatus.MS_SENT.toString())
                    message.setReason("报文发送成功")
                    File bakDir = new File(fileDirBak)
                    if(!bakDir.exists()){
                        bakDir.mkdirs()
                    }
                    File bakFile = new File(bakDir.getAbsolutePath()+"\\"+xmlFile.getName())
                    xmlFile.renameTo(bakFile)
                }else {
                    logger.info("进出监管场所:"+messageId+"报文发送失败")
                    message.setStatus(MessageStatus.MS_SEND_FAILURE.toString())
                    message.setReason("报文已生成，但上传FTP失败，报文发送失败")
                }
                message.setCreateTime(Utils.sdf.parse(Utils.sdf.format(new Date())))
//                ServiceUtil.publicService().add(message)
            }
        }catch (Exception e) {
            logger.info("进出监管场所:"+e.toString())
        }


    }

    public void reProcess(String xmlStr) {//重新处理报文
        try {
            if(xmlStr != null) {
                logger.info("进出监管场所:重新处理报文"+message.getMessageId())
                File xmlFile = this.generateXmlFile(xmlStr)
                if(this.sendFile(xmlFile)) {
                    logger.info("进出监管场所:"+message.getMessageId()+"报文发送成功")
                    message.setStatus(MessageStatus.MS_SENT.toString())
                    message.setReason("报文发送成功")
                    File bakDir = new File(fileDirBak)
                    if(!bakDir.exists()){
                        bakDir.mkdirs()
                    }
                    File bakFile = new File(bakDir.getAbsolutePath()+"\\"+xmlFile.getName())
                    xmlFile.renameTo(bakFile)
                }else {
                    logger.info("进出监管场所:"+message.getMessageId()+"报文发送失败")
                    message.setStatus(MessageStatus.MS_SEND_FAILURE.toString())
                    message.setReason("报文已生成，但上传FTP失败，报文发送失败")
                }
                //ServiceUtil.publicService().update(message)
            }
        }catch (Exception e) {
            logger.info("进出监管场所:"+e.toString())
        }
    }

    public void createXmlDefaultInfo() {
        messageType = "MT9901"
        sendId = "ZSDND"
        receiveId = "2904"
        barrierNum = "290401"
        sendTime = getXMLTime()
        messageId = messageType+"_"+sendId+"_"+receiveId+"_"+sendTime
        message.setSendTime(Utils.sdf.parse(Utils.sdf.format(Utils.sdfXML.parse(sendTime))))
        message.setMessageType(messageType)
        message.setMessageId(messageId)
    }

    public static synchronized String getXMLTime(){
        try{
            Thread.sleep(1000)
        }catch(Exception e){
            logger.error("进出监管场所:"+e.toString())
        }finally {
            Date d = new Date()
            return Utils.sdfXML.format(d)
        }
    }

    public String createXmlStr(Map<String, Object> param) {
        try {
            def xmlStringWriter = new StringWriter()
            def xmlBuilder = new MarkupBuilder(xmlStringWriter)
            StringBuffer strXML = new StringBuffer()
            strXML.append("""<?xml version="1.0" encoding="UTF-8" ?>"""+"\n")

            String xmlStr = param.get("servletXmlStr")//解析json字符串
            def declaration = new XmlParser().parseText(xmlStr)
            def applyHead = declaration.get("ApplyHead")[0]

            xmlBuilder.HarbourEDI(version:"1.0.0"){//生成xml字符串
                Head{
                    'MessageId'(messageId)
                    'MessageType'(messageType)
                    'SendId'(sendId)
                    'ReceiveId'(receiveId)
                    'BarrierNum'(barrierNum)
                    'SendTime'(sendTime)
                    'Obligate'("")
                }
                Declaration{
                    ApplyHead{
                        assert applyHead instanceof Node
                        'TransportTypeCode'(applyHead.get("TransportTypeCode").text())
                        'IEPortTypeCode'(applyHead.get("IEPortTypeCode").text())
                        'TransportName'(applyHead.get("TransportName").text())
                        'JouneyId'(applyHead.get("JouneyId").text())
                        'ShipUnCode'(applyHead.get("ShipUnCode").text())
                        'UnloadingStartDate'(applyHead.get("UnloadingStartDate").text())
                        'UnloadingEndDate'(applyHead.get("UnloadingEndDate").text())
                        'Obligate'(applyHead.get("Obligate").text())
                        def list = applyHead.get("ApplyList")
                        assert list instanceof List
                        list.each {applyList->
                            ApplyList{
                                assert applyList instanceof Node
                                'DocumentNum'(applyList.get("DocumentNum").text())
                                'GoodsType'(applyList.get("GoodsType").text())
                                'ContainerNum'(applyList.get("ContainerNum").text())
                                'FullnessCode'(applyList.get("FullnessCode").text())
                                'LockNum'(applyList.get("LockNum").text())
                                'Quantity'(applyList.get("Quantity").text())
                                'GrossWeight'(applyList.get("GrossWeight").text())
                                'Obligate1'(applyList.get("Obligate1").text())
                                'Obligate2'(applyList.get("Obligate2").text())
                            }
                        }
                    }
                }
            }
            return strXML.append(xmlStringWriter.toString())
        }catch (Exception e) {
            logger.error("进出监管场所:"+e.toString())
            message.setStatus(MessageStatus.MS_PARSE_FAILURE.toString())
            message.setReason("报文解析过程中出现异常，解析失败")
            return null
        }
    }

    public File generateXmlFile(String strXml) {
        try {
            if(strXml != null) {
//                message.setContent(strXml)
                File dir = new File(this.fileDir)
                if(!dir.exists()){
                    dir.mkdirs()
                }
                File xmlFile = new File(this.fileDir+"\\"+messageId+".xml")
                def printWriter = xmlFile.newPrintWriter('UTF-8')
                printWriter.append(strXml)
                printWriter.flush()
                printWriter.close()
                return xmlFile
            } else {
                return null
            }
        }catch (Exception e) {
            logger.error("进出监管场所:"+e.toString())
            message.setStatus(MessageStatus.MS_PARSE_FAILURE.toString())
            message.setReason("在报文文件生成过程中出现异常，解析失败")
            return null
        }

    }

    public boolean sendFile(File file) {
        try{
            return null;
//            return ServiceUtil.groovyService("ZSEDIFtpHandler").invokeMethod("uploadFile", file)
        }catch(Exception e){
            logger.error("进出监管场所:"+e.toString())
            message.setStatus(MessageStatus.MS_SEND_FAILURE.toString())
            message.setReason("在向FTP发送报文文件过程中出现异常，报文发送失败")
            return false
        }
    }

}
