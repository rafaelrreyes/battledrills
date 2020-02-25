/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ngc.battledrills.vmf;

import com.ngc.battledrills.BattleDrillsConfig;
import com.ngc.battledrills.manage.BattleDrillManager;
import com.ngc.battledrills.util.ConvenienceUtils;
import com.ngc.battledrills.util.ConvenienceUtils.VmfType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Mostly plagiarized from Ava's Link16 code
 */
public class VmfManager
{
    //private String m_vmfFilename = "C:\\h\\C2PCLink16Adapter\\kmsgs\\vmfmsg.bom";
    private String m_vmfFilename = "C:\\h\\C2PCWebApp\\webapps\\battledrills\\secure\\data\\kmsgs\\vmfmsg.bom";
    private File m_vmfFile = new File(m_vmfFilename);
    private Path m_vmfPath = Paths.get(m_vmfFilename);
    private Integer m_own_URN = -1;
    private Timer timer = null;
    
    public VmfManager()
    {
        setOwnUrn();
    }
    
    public boolean startKMessageMonitor() {
        boolean bStatus = true;
        KMessageMonitor task = new KMessageMonitor();
        timer = new Timer();
        timer.schedule(task, 0, 1000);
        return (bStatus);
    }
    
    public void stopKMessageMonitor()
    {
        timer.cancel();
    }
    
    private class KMessageMonitor extends TimerTask{
        @Override
        public void run() {
            if (m_vmfFile.exists()) {
                handleVmfFile();
            }
        }
    }
    
    private void handleVmfFile() {
        try {
            byte[] byteMessage = this.readVmfMsgFile();
            long lFileSize = Files.size(m_vmfPath);
            decodeVmfMessage(byteMessage, lFileSize);
            Files.deleteIfExists(m_vmfPath);
        } catch (IOException ioe) {
            System.err.println("VmfManager::handleVmfFile - error handling VMF message: " + ioe);
        }
    }
    
    //read content of file and return string
    private byte[] readVmfMsgFile() {
        byte[] contents = null;
        try {
            contents = Files.readAllBytes(m_vmfPath);
        } catch (Exception ioe) {
            System.err.println(ioe);
        }
        return contents;
    }

    private void decodeVmfMessage(byte[] byteBinaryMessage, long lMessageSize) {
        //byte[] byteDecodeBuffer = new byte[MSG_HDC_6017.BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE];
        //int iHeaderBufferSize[] = new int[1];
        //iHeaderBufferSize[0] = 0;
        
        // decode the header and ensure it's valid
        MSG_HDC_6017 milHdr = new MSG_HDC_6017();
        int iDecodeStatus = milHdr.DecodeMessage(byteBinaryMessage, (int) lMessageSize);
        
        if (iDecodeStatus != MSG_HDC_6017.ERROR_MSG_HDC_6017_NO_ERROR) {
            return;
        }
        
        // decode and process each message separately
        //int iUrn = (BattleDrillsConfig.devMode)? 2390709 : milHdr.GetG1UrnOriginator();

        // if me do not send
        // db 6/7/19 - this check is not needed for K7.1 (medevac), which is all we're processing at the moment, so we will leave it out for now
        //if (this.isOwnURN(iUrn)) {
            //return;
        //}
        
        int iNumberOfMessages = milHdr.GetR3RepeatGroupSize();
        for (int iR3 = 0; iR3 < iNumberOfMessages; iR3++) {
            //int iMsgType = 0;
            if (milHdr.GetR3UserMessageFormatCodes(iR3) != VmfConstants.UMF_VMF) {
                System.out.println("File does not contain any VMF messages");
                continue;
            }
            
            int iMsgStdVer = (BattleDrillsConfig.devMode)? 8 : milHdr.GetR3MessageStandardVersion(iR3);
            if (iMsgStdVer == -1) {
                System.out.println("Unknown/Invalid message std version");
                continue;
            }
            
            int iKSeries = milHdr.GetR3G4FunctionalAreaDesignator(iR3);
            int iMessageNumber = milHdr.GetR3G4MessageNumber(iR3);
            //int iHeaderOperationInd = milHdr.GetR3OperationIndicator(0);
            //String strHeaderOp = lookupDfiDiSet("6017B", "8001", "5", Integer.toString(iHeaderOperationInd));
            
            // Diana change this to allow for a user-based mapping from VMF Type to battle drill type
            if(isMedevac(iKSeries, iMessageNumber))
            {
                BattleDrillManager manager = BattleDrillManager.getInstance();
                manager.createFromVmf(VmfType.MEDEVAC);
            }
        }
    }
    
    private boolean isMedevac(int kSeries, int messageNumber)
    {
        return (kSeries == 7 && messageNumber == 1);
    }
    
    private Integer setOwnUrn() {
        String gwLocation = ConvenienceUtils.JTCW_REG_LOCATION + "\\c2pcgw\\Gateway";
        String key = "Gateway URN";
        if (m_own_URN == null) {
            try {
                String value = ConvenienceUtils.readWindowsRegistry(gwLocation, key, "REG_DWORD");
                if (StringUtils.isBlank(value) == false) {
                    m_own_URN = Integer.decode(value);
                }
            } catch (Exception e) {
                 System.err.println("VmfManager::setOwnUrn: " + e);
            }
        }
        
        return (m_own_URN == null)?2390709:m_own_URN;
    }
    
    /*private boolean isOwnURN(int urn) {
        return (m_own_URN.equals(urn));
    }*/
}

