/* Copyright Northrop Grumman Corporation (2018)
   All Rights Reserved.
   
   
   NOTICE: THIS CLASS IS AUTO-GENERATED USING THE VMF DATABASE AND WAS
           CREATED ON 3/27/2018 2:08:44 PM. DO NOT EDIT THIS CODE.
           EDITING THIS CODE WILL CAUSE UNEXPECTED RESULTS.
           CONTACT LOU FINK AT (858) 335-4317 FOR SUPPORT
   
   
*/

package com.ngc.battledrills.vmf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.zip.GZIPInputStream;
import ngc.c2pc.vmf.bitops.BitOps_6017;
import ngc.c2pc.vmf.vmfops.VmfOps_6017;


public class MSG_HDC_6017
{
  public static final int BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE=1048576; // 1MB
  public static final int MAX_MSG_HDC_6017_R1_GROUP=16;
public static final int MAX_MSG_HDC_6017_R2_GROUP=16;
public static final int MAX_MSG_HDC_6017_R3_GROUP=16;
public static final int MAX_MSG_HDC_6017_R4_GROUP=4;
public static final int MAX_MSG_HDC_6017_R5_GROUP=17;
  public static final int ERROR_MSG_HDC_6017_NO_ERROR=0;
  public static final int ERROR_MSG_HDC_6017_DECODE_ZERO_BYTES=1;
  public static final int ERROR_MSG_HDC_6017_DECODE_MAX_BYTES=2;
  public static final int ERROR_MSG_HDC_6017_DECODE_VERSION=3;
  public static final int ERROR_MSG_HDC_6017_DECODE_DATA_COMPRESSION_TYPE=4;
  public static final int ERROR_MSG_HDC_6017_DECODE_G1_URN_ORIGINATOR=5;
  public static final int ERROR_MSG_HDC_6017_DECODE_G1_UNIT_LONG_NAME=6;
  public static final int ERROR_MSG_HDC_6017_DECODE_G2R1_URN_RECIPIENT=7;
  public static final int ERROR_MSG_HDC_6017_DECODE_G2R1_UNIT_LONG_NAME=8;
  public static final int ERROR_MSG_HDC_6017_DECODE_G3R2_URN_INFORMATION_ADDRESSEE=9;
  public static final int ERROR_MSG_HDC_6017_DECODE_G3R2_UNIT_LONG_NAME=10;
  public static final int ERROR_MSG_HDC_6017_DECODE_HEADER_SIZE=11;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_USER_MESSAGE_FORMAT_CODES=12;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_STANDARD_VERSION=13;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G4_FUNCTIONAL_AREA_DESIGNATOR=14;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G4_MESSAGE_NUMBER=15;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G4_MESSAGE_SUBTYPE=16;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_FILE_NAME=17;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_SIZE=18;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_OPERATION_INDICATOR=19;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_RETRANSMIT_INDICATOR=20;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_PRECEDENCE_CODE=21;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_SECURITY_CLASSIFICATION_=22;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3_CONTROL_RELEASE_MARKING=23;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_YEAR=24;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_MONTH=25;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_DAY_OF_MONTH=26;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_HOUR=27;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_MINUTE=28;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_SECOND=29;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G5_DTG_EXTENSION=30;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_YEAR=31;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_MONTH=32;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_DAY_OF_MONTH=33;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_HOUR=34;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_MINUTE=35;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G6_SECOND=36;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G7_MACHINE_ACKNOWLEDGE_REQUEST=37;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G7_OPERATOR_ACKNOWLEDGE_REQUEST=38;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G7_OPERATOR_REPLY_REQUEST=39;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_YEAR=40;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_MONTH=41;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_DAY_OF_MONTH=42;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_HOUR=43;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_MINUTE=44;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_SECOND=45;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_DTG_EXTENSION=46;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_RECEIPT_COMPLIANCE_R_C=47;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_CANTCO_REASON_CODE=48;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_CANTPRO_REASON_CODE=49;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G8_REPLY_AMPLIFICATION=50;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_URN_=51;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_UNIT_LONG_NAME=52;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_YEAR=53;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_MONTH=54;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_DAY_OF_MONTH=55;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_HOUR=56;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_MINUTE=57;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_SECOND=58;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G9R4_DTG_EXTENSION=59;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10_SECURITY_PARAMETERS_INFORMATION_SPI=60;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G11_KEYING_MATERIAL_ID_LENGTH=61;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G11_KEYING_MATERIAL_ID=62;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION_LENGTH=63;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION=64;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G13_KEY_TOKEN_LENGTH=65;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G13R5_KEY_TOKEN=66;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G14_AUTHENTICATION_DATA_A_LENGTH=67;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G14_AUTHENTICATION_DATA_A=68;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G15_AUTHENTICATION_DATA_B_LENGTH=69;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G15_AUTHENTICATION_DATA_B=70;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10_SIGNED_ACKNOWLEDGE_REQUEST_INDICATOR=71;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G16_MESSAGE_SECURITY_PADDING_LENGTH=72;
  public static final int ERROR_MSG_HDC_6017_DECODE_R3G10G16_MESSAGE_SECURITY_PADDING=73;
  public static final int ERROR_MSG_HDC_6017_ENCODE_VERSION=74;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3_USER_MESSAGE_FORMAT_CODES=75;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G4_FUNCTIONAL_AREA_DESIGNATOR=76;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G4_MESSAGE_NUMBER=77;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3_OPERATION_INDICATOR=78;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3_RETRANSMIT_INDICATOR=79;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3_MESSAGE_PRECEDENCE_CODE=80;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3_SECURITY_CLASSIFICATION_=81;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_YEAR=82;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_MONTH=83;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_DAY_OF_MONTH=84;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_HOUR=85;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_MINUTE=86;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G5_SECOND=87;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_YEAR=88;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_MONTH=89;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_DAY_OF_MONTH=90;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_HOUR=91;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_MINUTE=92;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G6_SECOND=93;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G7_MACHINE_ACKNOWLEDGE_REQUEST=94;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G7_OPERATOR_ACKNOWLEDGE_REQUEST=95;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G7_OPERATOR_REPLY_REQUEST=96;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_YEAR=97;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_MONTH=98;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_DAY_OF_MONTH=99;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_HOUR=100;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_MINUTE=101;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_SECOND=102;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G8_RECEIPT_COMPLIANCE_R_C=103;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_YEAR=104;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_MONTH=105;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_DAY_OF_MONTH=106;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_HOUR=107;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_MINUTE=108;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G9R4_SECOND=109;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10_SECURITY_PARAMETERS_INFORMATION_SPI=110;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G11_KEYING_MATERIAL_ID_LENGTH=111;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G11_KEYING_MATERIAL_ID=112;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION_LENGTH=113;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION=114;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G13_KEY_TOKEN_LENGTH=115;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G13R5_KEY_TOKEN=116;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G14_AUTHENTICATION_DATA_A_LENGTH=117;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G14_AUTHENTICATION_DATA_A=118;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G15_AUTHENTICATION_DATA_B_LENGTH=119;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G15_AUTHENTICATION_DATA_B=120;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10_SIGNED_ACKNOWLEDGE_REQUEST_INDICATOR=121;
  public static final int ERROR_MSG_HDC_6017_ENCODE_R3G10G16_MESSAGE_SECURITY_PADDING_LENGTH=122;
  public static final int ERROR_MSG_HDC_6017_ENCODE_MEMORY=123;

  private char[] m_pEncodeBuffer;
private int m_iDecodeBitOffset;
    short m_sVersion;
    short m_sDataCompressionType;
    int m_iG1UrnOriginator;
    String m_strG1UnitLongName = "";
  Vector<_CMSG_HDC_6017_R1> m_deqR1 = new Vector<_CMSG_HDC_6017_R1>();
  Vector<_CMSG_HDC_6017_R2> m_deqR2 = new Vector<_CMSG_HDC_6017_R2>();
    int m_iHeaderSize;
  Vector<_CMSG_HDC_6017_R3> m_deqR3 = new Vector<_CMSG_HDC_6017_R3>();

  public MSG_HDC_6017()
  {
    m_pEncodeBuffer = null;
  
    m_sVersion = -1;
    m_sDataCompressionType = -1;
    m_iG1UrnOriginator = -1;
    m_strG1UnitLongName = "";
    m_iHeaderSize = -1;
  }

  public MSG_HDC_6017( MSG_HDC_6017 rhs )
  {
    if ( !this.equals(rhs) )
    {
      m_pEncodeBuffer = null;
    }
  m_sVersion = rhs.m_sVersion;
  m_sDataCompressionType = rhs.m_sDataCompressionType;
  m_iG1UrnOriginator = rhs.m_iG1UrnOriginator;
  m_strG1UnitLongName = rhs.m_strG1UnitLongName;
  m_deqR1 = rhs.m_deqR1;
  m_deqR2 = rhs.m_deqR2;
  m_iHeaderSize = rhs.m_iHeaderSize;
  m_deqR3 = rhs.m_deqR3;
  }

  public void Destruct()
  {
    m_pEncodeBuffer = null;
  }

  public void Copy( MSG_HDC_6017 rhs )
  {
    if ( this.equals(rhs) )
      return;
  
    if ( m_pEncodeBuffer != null )
    {
      m_pEncodeBuffer = null;
    }
  
  m_sVersion = rhs.m_sVersion;
  m_sDataCompressionType = rhs.m_sDataCompressionType;
  m_iG1UrnOriginator = rhs.m_iG1UrnOriginator;
  m_strG1UnitLongName = rhs.m_strG1UnitLongName;
  m_deqR1 = rhs.m_deqR1;
  m_deqR2 = rhs.m_deqR2;
  m_iHeaderSize = rhs.m_iHeaderSize;
  m_deqR3 = rhs.m_deqR3;
}

  public void Clear()
  {
    if ( m_pEncodeBuffer != null )
    {
      m_pEncodeBuffer = null;
    }
  
  m_sVersion = -1;
  m_sDataCompressionType = -1;
  m_iG1UrnOriginator = -1;
  m_strG1UnitLongName = "";
  m_deqR1.clear();
  m_deqR2.clear();
  m_iHeaderSize = -1;
  m_deqR3.clear();
}

  public void ClearEncodeBuffer()
  {
    if ( m_pEncodeBuffer != null )
    {
      m_pEncodeBuffer = null;
    }
  }

  class _CMSG_HDC_6017_R1
  {

    int m_iG2R1UrnRecipient;
    String m_strG2R1UnitLongName = "";

  public _CMSG_HDC_6017_R1()
  {
    m_iG2R1UrnRecipient = -1;
    m_strG2R1UnitLongName = "";
  }

  public void Destruct_R1()
  {
  }

  }

  class _CMSG_HDC_6017_R2
  {

    int m_iG3R2UrnInformationAddressee;
    String m_strG3R2UnitLongName = "";

  public _CMSG_HDC_6017_R2()
  {
    m_iG3R2UrnInformationAddressee = -1;
    m_strG3R2UnitLongName = "";
  }

  public void Destruct_R2()
  {
  }

  }

  class _CMSG_HDC_6017_R3
  {

    short m_sR3UserMessageFormatCodes;
    short m_sR3MessageStandardVersion;
    short m_sR3G4FunctionalAreaDesignator;
    short m_sR3G4MessageNumber;
    short m_sR3G4MessageSubtype;
    String m_strR3FileName = "";
    int m_iR3MessageSize;
    short m_sR3OperationIndicator;
    short m_sR3RetransmitIndicator;
    short m_sR3MessagePrecedenceCode;
    short m_sR3SecurityClassification;
    String m_strR3ControlReleaseMarking = "";
    short m_sR3G5Year;
    short m_sR3G5Month;
    short m_sR3G5DayOfMonth;
    short m_sR3G5Hour;
    short m_sR3G5Minute;
    short m_sR3G5Second;
    short m_sR3G5DtgExtension;
    short m_sR3G6Year;
    short m_sR3G6Month;
    short m_sR3G6DayOfMonth;
    short m_sR3G6Hour;
    short m_sR3G6Minute;
    short m_sR3G6Second;
    short m_sR3G7MachineAcknowledgeRequest;
    short m_sR3G7OperatorAcknowledgeRequest;
    short m_sR3G7OperatorReplyRequest;
    short m_sR3G8Year;
    short m_sR3G8Month;
    short m_sR3G8DayOfMonth;
    short m_sR3G8Hour;
    short m_sR3G8Minute;
    short m_sR3G8Second;
    short m_sR3G8DtgExtension;
    short m_sR3G8ReceiptComplianceRC;
    short m_sR3G8CantcoReasonCode;
    short m_sR3G8CantproReasonCode;
    String m_strR3G8ReplyAmplification = "";
  Vector<_CMSG_HDC_6017_R3R4> m_deqR4 = new Vector<_CMSG_HDC_6017_R3R4>();
    short m_sR3G10SecurityParametersInformationSpi;
    short m_sR3G10G11KeyingMaterialIdLength;
    short m_sR3G10G11KeyingMaterialId;
    short m_sR3G10G12CryptographicInitializationLength;
    short m_sR3G10G12CryptographicInitialization;
    short m_sR3G10G13KeyTokenLength;
  Vector<_CMSG_HDC_6017_R3R5> m_deqR5 = new Vector<_CMSG_HDC_6017_R3R5>();
    short m_sR3G10G14AuthenticationDataALength;
    short m_sR3G10G14AuthenticationDataA;
    short m_sR3G10G15AuthenticationDataBLength;
    short m_sR3G10G15AuthenticationDataB;
    short m_sR3G10SignedAcknowledgeRequestIndicator;
    short m_sR3G10G16MessageSecurityPaddingLength;
    short m_sR3G10G16MessageSecurityPadding;

  public _CMSG_HDC_6017_R3()
  {
    m_sR3UserMessageFormatCodes = -1;
    m_sR3MessageStandardVersion = -1;
    m_sR3G4FunctionalAreaDesignator = -1;
    m_sR3G4MessageNumber = -1;
    m_sR3G4MessageSubtype = -1;
    m_strR3FileName = "";
    m_iR3MessageSize = -1;
    m_sR3OperationIndicator = -1;
    m_sR3RetransmitIndicator = -1;
    m_sR3MessagePrecedenceCode = -1;
    m_sR3SecurityClassification = -1;
    m_strR3ControlReleaseMarking = "";
    m_sR3G5Year = -1;
    m_sR3G5Month = -1;
    m_sR3G5DayOfMonth = -1;
    m_sR3G5Hour = -1;
    m_sR3G5Minute = -1;
    m_sR3G5Second = -1;
    m_sR3G5DtgExtension = -1;
    m_sR3G6Year = -1;
    m_sR3G6Month = -1;
    m_sR3G6DayOfMonth = -1;
    m_sR3G6Hour = -1;
    m_sR3G6Minute = -1;
    m_sR3G6Second = -1;
    m_sR3G7MachineAcknowledgeRequest = -1;
    m_sR3G7OperatorAcknowledgeRequest = -1;
    m_sR3G7OperatorReplyRequest = -1;
    m_sR3G8Year = -1;
    m_sR3G8Month = -1;
    m_sR3G8DayOfMonth = -1;
    m_sR3G8Hour = -1;
    m_sR3G8Minute = -1;
    m_sR3G8Second = -1;
    m_sR3G8DtgExtension = -1;
    m_sR3G8ReceiptComplianceRC = -1;
    m_sR3G8CantcoReasonCode = -1;
    m_sR3G8CantproReasonCode = -1;
    m_strR3G8ReplyAmplification = "";
    m_sR3G10SecurityParametersInformationSpi = -1;
    m_sR3G10G11KeyingMaterialIdLength = -1;
    m_sR3G10G11KeyingMaterialId = 0;
    m_sR3G10G12CryptographicInitializationLength = -1;
    m_sR3G10G12CryptographicInitialization = 0;
    m_sR3G10G13KeyTokenLength = -1;
    m_sR3G10G14AuthenticationDataALength = -1;
    m_sR3G10G14AuthenticationDataA = 0;
    m_sR3G10G15AuthenticationDataBLength = -1;
    m_sR3G10G15AuthenticationDataB = 0;
    m_sR3G10SignedAcknowledgeRequestIndicator = -1;
    m_sR3G10G16MessageSecurityPaddingLength = -1;
    m_sR3G10G16MessageSecurityPadding = 0;
  }

  public void Destruct_R3()
  {
  }

  }

  class _CMSG_HDC_6017_R3R4
  {

    int m_iR3G9R4Urn;
    String m_strR3G9R4UnitLongName = "";
    short m_sR3G9R4Year;
    short m_sR3G9R4Month;
    short m_sR3G9R4DayOfMonth;
    short m_sR3G9R4Hour;
    short m_sR3G9R4Minute;
    short m_sR3G9R4Second;
    short m_sR3G9R4DtgExtension;

  public _CMSG_HDC_6017_R3R4()
  {
    m_iR3G9R4Urn = -1;
    m_strR3G9R4UnitLongName = "";
    m_sR3G9R4Year = -1;
    m_sR3G9R4Month = -1;
    m_sR3G9R4DayOfMonth = -1;
    m_sR3G9R4Hour = -1;
    m_sR3G9R4Minute = -1;
    m_sR3G9R4Second = -1;
    m_sR3G9R4DtgExtension = -1;
  }

  public void Destruct_R3R4()
  {
  }

  }

  class _CMSG_HDC_6017_R3R5
  {

    short m_sR3G10G13R5KeyToken;

  public _CMSG_HDC_6017_R3R5()
  {
    m_sR3G10G13R5KeyToken = 0;
  }

  public void Destruct_R3R5()
  {
  }

  }

public int EncodeMessage( byte[] pBuffer, int[] iLength )
{
  int iError = ERROR_MSG_HDC_6017_NO_ERROR;

  try
  {
    int[] iEncodeBitOffset = new int[1];
    iEncodeBitOffset[0] = 0;
    int[] iHeaderSizeBitOffset = new int[1];
    iHeaderSizeBitOffset[0] = 0;
    int iTotalLengthInBits = BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE * 8;

    if ( m_pEncodeBuffer != null)
    {
      m_pEncodeBuffer = null;
    }

    char[] pMessage = new char[ BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE ];

    if ( pMessage != null )
    {
      for( int nMsgIndex=0; nMsgIndex< BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE; nMsgIndex++)
      {
        pMessage[nMsgIndex] = 0;
      }

      // 1. VERSION
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        iError = ERROR_MSG_HDC_6017_ENCODE_VERSION;
        if ( m_sVersion != -1 )
        {
          BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_sVersion );
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
      
      // 2.1 [FPI] DATA COMPRESSION TYPE
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( m_sDataCompressionType != -1 )
        {
          BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
          BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 2, m_sDataCompressionType );
        }
        else
        {
          BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
        }
      }
      
      // 3. [GPI] GPI FOR G1.  ORIGINATOR ADDRESS GROUP.
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( IsG1GroupPresent() )
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
      
          // 3.1.1 [FPI] URN
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            if ( m_iG1UrnOriginator != -1 )
            {
              BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
              BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 24, m_iG1UrnOriginator );
            }
            else
            {
              BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
            }
          }
          
          // 3.2.1 [FPI] UNIT LONG NAME
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            if ( m_strG1UnitLongName != "" )
            {
              BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
              BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 448, m_strG1UnitLongName );
            }
            else
            {
              BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
            }
          }
          
        }
        else
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
        }
      } //END G1
      
      // 4. [GPI] GPI FOR G2.  RECIPIENT ADDRESS GROUP.
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( IsG2GroupPresent() )
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
      
          // R1
          int iR1Size = (int) m_deqR1.size();
          for ( int iR1Index = 0; iR1Index < iR1Size && iError == ERROR_MSG_HDC_6017_NO_ERROR; iR1Index++ )
          {
            // 4.1.1 GRI FOR R1.
            BitOps_6017.SET_GRI( pMessage, iEncodeBitOffset, iTotalLengthInBits, ( iR1Size - ( iR1Index + 1 ) != 0 ) );
          
            // 4.1.2.1 [FPI] URN
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR1.get(iR1Index).m_iG2R1UrnRecipient != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 24, m_deqR1.get(iR1Index).m_iG2R1UrnRecipient );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
            // 4.1.3.1 [FPI] UNIT LONG NAME
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR1.get(iR1Index).m_strG2R1UnitLongName != "" )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 448, m_deqR1.get(iR1Index).m_strG2R1UnitLongName );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
          } //END R1
          
        }
        else
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
        }
      } //END G2
      
      // 5. [GPI] GPI FOR G3.  INFORMATION ADDRESS GROUP.
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( IsG3GroupPresent() )
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
      
          // R2
          int iR2Size = (int) m_deqR2.size();
          for ( int iR2Index = 0; iR2Index < iR2Size && iError == ERROR_MSG_HDC_6017_NO_ERROR; iR2Index++ )
          {
            // 5.1.1 GRI FOR R2.
            BitOps_6017.SET_GRI( pMessage, iEncodeBitOffset, iTotalLengthInBits, ( iR2Size - ( iR2Index + 1 ) != 0 ) );
          
            // 5.1.2.1 [FPI] URN
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 24, m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
            // 5.1.3.1 [FPI] UNIT LONG NAME
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR2.get(iR2Index).m_strG3R2UnitLongName != "" )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 448, m_deqR2.get(iR2Index).m_strG3R2UnitLongName );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
          } //END R2
          
        }
        else
        {
          BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
        }
      } //END G3
      
      // 6.1 [FPI] HEADER SIZE
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        iHeaderSizeBitOffset[0] = iEncodeBitOffset[0];
        iEncodeBitOffset[0] += 16;
      }
      
      // R3
      int iR3Size = (int) m_deqR3.size();
      for ( int iR3Index = 0; iR3Index < iR3Size && iError == ERROR_MSG_HDC_6017_NO_ERROR; iR3Index++ )
      {
        // 7.1 GRI FOR R3.  MESSAGE HANDLING GROUP.
        BitOps_6017.SET_GRI( pMessage, iEncodeBitOffset, iTotalLengthInBits, ( iR3Size - ( iR3Index + 1 ) != 0 ) );
      
        // 7.2 USER MESSAGE FORMAT CODES
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_R3_USER_MESSAGE_FORMAT_CODES;
          if ( m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes != -1 )
          {
            BitOps_6017.SET_DFINO_8001_DISET_7( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes );
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
        
        // 7.3.1 [FPI] MESSAGE STANDARD VERSION
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( m_deqR3.get(iR3Index).m_sR3MessageStandardVersion != -1 )
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3MessageStandardVersion );
          }
          else
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        }
        
        // 7.4 [GPI] GPI FOR G4.  MESSAGE IDENTIFICATION GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG4GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.4.1 FUNCTIONAL AREA DESIGNATOR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G4_FUNCTIONAL_AREA_DESIGNATOR;
              if ( m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.4.2 MESSAGE NUMBER
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G4_MESSAGE_NUMBER;
              if ( m_deqR3.get(iR3Index).m_sR3G4MessageNumber != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G4MessageNumber );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.4.3.1 [FPI] MESSAGE SUBTYPE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_sR3G4MessageSubtype != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G4MessageSubtype );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G4
        
        // 7.5.1 [FPI] FILE NAME
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( m_deqR3.get(iR3Index).m_strR3FileName != "" )
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 448, m_deqR3.get(iR3Index).m_strR3FileName );
          }
          else
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        }
        
        // 7.6.1 [FPI] MESSAGE SIZE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( m_deqR3.get(iR3Index).m_iR3MessageSize != -1 )
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 20, m_deqR3.get(iR3Index).m_iR3MessageSize );
          }
          else
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        }
        
        // 7.7 OPERATION INDICATOR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_R3_OPERATION_INDICATOR;
          if ( m_deqR3.get(iR3Index).m_sR3OperationIndicator != -1 )
          {
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 2, m_deqR3.get(iR3Index).m_sR3OperationIndicator );
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
        
        // 7.8 RETRANSMIT INDICATOR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_R3_RETRANSMIT_INDICATOR;
          if ( m_deqR3.get(iR3Index).m_sR3RetransmitIndicator != -1 )
          {
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1, m_deqR3.get(iR3Index).m_sR3RetransmitIndicator );
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
        
        // 7.9 MESSAGE PRECEDENCE CODE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_R3_MESSAGE_PRECEDENCE_CODE;
          if ( m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode != -1 )
          {
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 3, m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode );
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
        
        // 7.10 SECURITY CLASSIFICATION
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_R3_SECURITY_CLASSIFICATION_;
          if ( m_deqR3.get(iR3Index).m_sR3SecurityClassification != -1 )
          {
            BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 2, m_deqR3.get(iR3Index).m_sR3SecurityClassification );
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
        
        // 7.11.1 [FPI] CONTROL/RELEASE MARKING
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking != "" )
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 224, m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking );
          }
          else
          {
            BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        }
        
        // 7.12 [GPI] GPI FOR G5.  ORIGINATOR DATE TIME GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG5GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.12.1 YEAR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_YEAR;
              if ( m_deqR3.get(iR3Index).m_sR3G5Year != -1 )
              {
                BitOps_6017.SET_DFINO_4098_DISET_1( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G5Year );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.2 MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G5Month != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G5Month );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.3 DAY OF MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_DAY_OF_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G5DayOfMonth != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G5DayOfMonth );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.4 HOUR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_HOUR;
              if ( m_deqR3.get(iR3Index).m_sR3G5Hour != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G5Hour );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.5 MINUTE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_MINUTE;
              if ( m_deqR3.get(iR3Index).m_sR3G5Minute != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G5Minute );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.6 SECOND
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G5_SECOND;
              if ( m_deqR3.get(iR3Index).m_sR3G5Second != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G5Second );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.12.7.1 [FPI] DTG EXTENSION
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_sR3G5DtgExtension != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 12, m_deqR3.get(iR3Index).m_sR3G5DtgExtension );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G5
        
        // 7.13 [GPI] GPI FOR G6.  PERISHABILITY DATE TIME GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG6GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.13.1 YEAR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_YEAR;
              if ( m_deqR3.get(iR3Index).m_sR3G6Year != -1 )
              {
                BitOps_6017.SET_DFINO_4098_DISET_1( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G6Year );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.13.2 MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G6Month != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G6Month );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.13.3 DAY OF MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_DAY_OF_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G6DayOfMonth != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G6DayOfMonth );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.13.4 HOUR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_HOUR;
              if ( m_deqR3.get(iR3Index).m_sR3G6Hour != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G6Hour );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.13.5 MINUTE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_MINUTE;
              if ( m_deqR3.get(iR3Index).m_sR3G6Minute != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G6Minute );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.13.6 SECOND
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G6_SECOND;
              if ( m_deqR3.get(iR3Index).m_sR3G6Second != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G6Second );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G6
        
        // 7.14 [GPI] GPI FOR G7.  ACKNOWLEDGEMENT REQUEST GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG7GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.14.1 MACHINE ACKNOWLEDGE REQUEST
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G7_MACHINE_ACKNOWLEDGE_REQUEST;
              if ( m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1, m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.14.2 OPERATOR ACKNOWLEDGE REQUEST
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G7_OPERATOR_ACKNOWLEDGE_REQUEST;
              if ( m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1, m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.14.3 OPERATOR REPLY REQUEST
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G7_OPERATOR_REPLY_REQUEST;
              if ( m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1, m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G7
        
        // 7.15 [GPI] GPI FOR G8.  RESPONSE DATA GROUP.  DTG OF MESSAGE BEING ACKNOWLEDGED.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG8GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.15.1 YEAR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_YEAR;
              if ( m_deqR3.get(iR3Index).m_sR3G8Year != -1 )
              {
                BitOps_6017.SET_DFINO_4098_DISET_1( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G8Year );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.2 MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G8Month != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G8Month );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.3 DAY OF MONTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_DAY_OF_MONTH;
              if ( m_deqR3.get(iR3Index).m_sR3G8DayOfMonth != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G8DayOfMonth );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.4 HOUR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_HOUR;
              if ( m_deqR3.get(iR3Index).m_sR3G8Hour != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_sR3G8Hour );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.5 MINUTE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_MINUTE;
              if ( m_deqR3.get(iR3Index).m_sR3G8Minute != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G8Minute );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.6 SECOND
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_SECOND;
              if ( m_deqR3.get(iR3Index).m_sR3G8Second != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G8Second );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.7.1 [FPI] DTG EXTENSION
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_sR3G8DtgExtension != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 12, m_deqR3.get(iR3Index).m_sR3G8DtgExtension );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
            // 7.15.8 RECEIPT/COMPLIANCE (R/C)
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G8_RECEIPT_COMPLIANCE_R_C;
              if ( m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 3, m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.15.9.1 [FPI] CANTCO REASON CODE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 3, m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
            // 7.15.10.1 [FPI] CANTPRO REASON CODE
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode != -1 )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
            // 7.15.11.1 [FPI] REPLY AMPLIFICATION
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification != "" )
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 350, m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification );
              }
              else
              {
                BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            }
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G8
        
        // 7.16 [GPI] GPI FOR G9.  REFERENCE MESSAGE DATA GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG9GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // R3R4
            int iR4Size = (int) m_deqR3.get(iR3Index).m_deqR4.size();
            for ( int iR4Index = 0; iR4Index < iR4Size && iError == ERROR_MSG_HDC_6017_NO_ERROR; iR4Index++ )
            {
              // 7.16.1.1 GRI FOR R4.
              BitOps_6017.SET_GRI( pMessage, iEncodeBitOffset, iTotalLengthInBits, ( iR4Size - ( iR4Index + 1 ) != 0 ) );
            
              // 7.16.1.2.1 [FPI] URN
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn != -1 )
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 24, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn );
                }
                else
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
                }
              }
              
              // 7.16.1.3.1 [FPI] UNIT LONG NAME
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName != "" )
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                  BitOps_6017.SET_ASCII_TEXT( pMessage, iEncodeBitOffset, iTotalLengthInBits, 448, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName );
                }
                else
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
                }
              }
              
              // 7.16.1.4 YEAR
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_YEAR;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year != -1 )
                {
                  BitOps_6017.SET_DFINO_4098_DISET_1( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.5 MONTH
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_MONTH;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month != -1 )
                {
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.6 DAY OF MONTH
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_DAY_OF_MONTH;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth != -1 )
                {
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.7 HOUR
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_HOUR;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour != -1 )
                {
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 5, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.8 MINUTE
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_MINUTE;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute != -1 )
                {
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.9 SECOND
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_ENCODE_R3G9R4_SECOND;
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second != -1 )
                {
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 6, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second );
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
              
              // 7.16.1.10.1 [FPI] DTG EXTENSION
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension != -1 )
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                  BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 12, m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension );
                }
                else
                {
                  BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
                }
              }
              
            } //END R4
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G9
        
        // 7.17 [GPI] GPI FOR G10.  MESSAGE SECURITY GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( IsG10GroupPresent( iR3Index ) )
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
        
            // 7.17.1 SECURITY PARAMETERS INFORMATION (SPI)
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G10_SECURITY_PARAMETERS_INFORMATION_SPI;
              if ( m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.17.2 [GPI] GPI FOR G11.  KEYING MATERIAL GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG11GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.2.1 KEYING MATERIAL ID LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G11_KEYING_MATERIAL_ID_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 3, m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // 7.17.2.2 KEYING MATERIAL ID
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G11_KEYING_MATERIAL_ID;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId != 0 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 64, m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G11
            
            // 7.17.3 [GPI] GPI FOR G12.  CRYPTOGRAPHIC INITIALIZATION GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG12GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.3.1 CRYPTOGRAPHIC INITIALIZATION LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 4, m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // 7.17.3.2 CRYPTOGRAPHIC INITIALIZATION
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization != 0 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1024, m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G12
            
            // 7.17.4 [GPI] GPI FOR G13.  KEY TOKEN GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG13GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.4.1 KEY TOKEN LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G13_KEY_TOKEN_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 8, m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // R3R5
                int iR5Size = (int) m_deqR3.get(iR3Index).m_deqR5.size();
                for ( int iR5Index = 0; iR5Index < iR5Size && iError == ERROR_MSG_HDC_6017_NO_ERROR; iR5Index++ )
                {
                  // 7.17.4.2.1 
                  BitOps_6017.SET_GRI( pMessage, iEncodeBitOffset, iTotalLengthInBits, ( iR5Size - ( iR5Index + 1 ) != 0 ) );
                
                  // 7.17.4.2.2 KEY TOKEN
                  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                  {
                    iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G13R5_KEY_TOKEN;
                    if ( m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken != 0 )
                    {
                      BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 16384, m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken );
                      iError = ERROR_MSG_HDC_6017_NO_ERROR;
                    }
                  }
                  
                } //END R5
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G13
            
            // 7.17.5 [GPI] GPI FOR G14.  AUTHENTICATION (A) GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG14GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.5.1 AUTHENTICATION DATA (A) LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G14_AUTHENTICATION_DATA_A_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // 7.17.5.2 AUTHENTICATION DATA (A)
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G14_AUTHENTICATION_DATA_A;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA != 0 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 8192, m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G14
            
            // 7.17.6 [GPI] GPI FOR G15.  AUTHENTICATION (B) GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG15GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.6.1 AUTHENTICATION DATA (B) LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G15_AUTHENTICATION_DATA_B_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 7, m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // 7.17.6.2 AUTHENTICATION DATA (B)
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G15_AUTHENTICATION_DATA_B;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB != 0 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 8192, m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G15
            
            // 7.17.7 SIGNED ACKNOWLEDGE REQUEST INDICATOR
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_ENCODE_R3G10_SIGNED_ACKNOWLEDGE_REQUEST_INDICATOR;
              if ( m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator != -1 )
              {
                BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 1, m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator );
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
            
            // 7.17.8 [GPI] GPI FOR G16.  MESSAGE SECURITY PADDING GROUP.
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( IsG16GroupPresent( iR3Index ) )
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
            
                // 7.17.8.1 MESSAGE SECURITY PADDING LENGTH
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  iError = ERROR_MSG_HDC_6017_ENCODE_R3G10G16_MESSAGE_SECURITY_PADDING_LENGTH;
                  if ( m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength != -1 )
                  {
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 8, m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength );
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
                
                // 7.17.8.2.1 [FPI] MESSAGE SECURITY PADDING
                if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
                {
                  if ( m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding != 0 )
                  {
                    BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, true );
                    BitOps_6017.SET_BIT_VALUE( pMessage, iEncodeBitOffset, iTotalLengthInBits, 2040, m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding );
                  }
                  else
                  {
                    BitOps_6017.SET_FPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
                  }
                }
                
              }
              else
              {
                BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
              }
            } //END G16
            
          }
          else
          {
            BitOps_6017.SET_GPI( pMessage, iEncodeBitOffset, iTotalLengthInBits, false );
          }
        } //END G10
        
      } //END R3
      
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        // Calculate length, must be byte aligned
        iLength[0]  = iEncodeBitOffset[0]/ 8;
        int iBitOffset = iEncodeBitOffset[0] % 8;
        
        if ( iBitOffset != 0 )
        {
          iLength[0] = iLength[0] + 1;
        }
        
        if( PutHeaderSize(iLength[0]) )
        {
            BitOps_6017.SET_BIT_VALUE(pMessage, iHeaderSizeBitOffset, iTotalLengthInBits, 16, m_iHeaderSize);
        }
        
        // Allocate new buffer
        m_pEncodeBuffer = new char[ iLength[0] ];
        if ( m_pEncodeBuffer != null )
        {
          for( int index=0; index<iLength[0]; index++ )
          {
              m_pEncodeBuffer[index] = pMessage[index];
              pBuffer[index] = (byte)(pMessage[index] & 0x00FF);
          }
        }
        else
        {
          iError = ERROR_MSG_HDC_6017_ENCODE_MEMORY;
        }
      }

      pMessage = null;

    }

  }
  catch ( Exception e )
  {
    // Do Nothing
  }

  return iError;

} // End Encode Message

public int DecodeMessage( byte[] arrByteBuffer, int iLength )
{

  m_iDecodeBitOffset = 0; 
  int[] iDecodeBitOffset = new int[1];
  iDecodeBitOffset[0] = 0;
  int iError = ERROR_MSG_HDC_6017_NO_ERROR;
  int iTotalLengthInBits = 0;

  char[] pBuffer = null;
  if (arrByteBuffer != null)
  {
    pBuffer = new char[iLength];
    for (int i = 0; i < iLength; i++)
    {
      pBuffer[i] = (char)arrByteBuffer[i];
    }
  }

  // Verify Message Length
  if ( iLength == 0 || pBuffer == null )
  {
    iError = ERROR_MSG_HDC_6017_DECODE_ZERO_BYTES;
  }
  else if ( iLength > BYTES_MSG_HDC_6017_MAXIMUM_MESSAGE_SIZE )
  {
    iError = ERROR_MSG_HDC_6017_DECODE_MAX_BYTES;
  }
  else
  {
    iTotalLengthInBits = iLength * 8;
  }

  // Begin Decode
  long[] uiValue = new long[1];
  uiValue[0] = 0;
  short[] sValue = new short[1];
  sValue[0] = 0;
  String[] csValue = new String[1];
  csValue[0] = "";

  // 1. VERSION
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    iError = ERROR_MSG_HDC_6017_DECODE_VERSION;
    if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
    {
      if ( PutVersion( (short) uiValue[0] ) )
      {
        iError = ERROR_MSG_HDC_6017_NO_ERROR;
      }
    }
  }
  
  // 2.1 [FPI] DATA COMPRESSION TYPE
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_DATA_COMPRESSION_TYPE;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 2, uiValue ) )
      {
        if ( PutDataCompressionType( (short) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
  }
  
  // 3. [GPI] GPI FOR G1.  ORIGINATOR ADDRESS GROUP.
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
    {
  
      // 3.1.1 [FPI] URN
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_G1_URN_ORIGINATOR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 24, uiValue ) )
          {
            if ( PutG1UrnOriginator( (int) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
      }
      
      // 3.2.1 [FPI] UNIT LONG NAME
      if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
      {
        if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_G1_UNIT_LONG_NAME;
          if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 448, csValue ) )
          {
            if ( PutG1UnitLongName( csValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
      }
      
    }
  } //END G1
  
  // 4. [GPI] GPI FOR G2.  RECIPIENT ADDRESS GROUP.
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
    {
  
      // 4.1.1 R1
      boolean bIsAnotherR1 = true;
      while ( ( bIsAnotherR1 ) &&
              ( iError == ERROR_MSG_HDC_6017_NO_ERROR ) &&
              ( m_deqR1.size() < MAX_MSG_HDC_6017_R1_GROUP ) )
      {
      
        _CMSG_HDC_6017_R1 R1Group = new _CMSG_HDC_6017_R1();
      
        m_deqR1.add( R1Group );
        int iR1Index = (int) m_deqR1.size() - 1;
      
        // 4.1.1 GRI FOR R1.
        bIsAnotherR1 = BitOps_6017.GET_GRI( pBuffer, iDecodeBitOffset, iTotalLengthInBits );
      
        // 4.1.2.1 [FPI] URN
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_G2R1_URN_RECIPIENT;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 24, uiValue ) )
            {
              if ( PutG2R1UrnRecipient( iR1Index, (int) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
        // 4.1.3.1 [FPI] UNIT LONG NAME
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_G2R1_UNIT_LONG_NAME;
            if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 448, csValue ) )
            {
              if ( PutG2R1UnitLongName( iR1Index, csValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
      } //END R1
      
    }
  } //END G2
  
  // 5. [GPI] GPI FOR G3.  INFORMATION ADDRESS GROUP.
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
    {
  
      // 5.1.1 R2
      boolean bIsAnotherR2 = true;
      while ( ( bIsAnotherR2 ) &&
              ( iError == ERROR_MSG_HDC_6017_NO_ERROR ) &&
              ( m_deqR2.size() < MAX_MSG_HDC_6017_R2_GROUP ) )
      {
      
        _CMSG_HDC_6017_R2 R2Group = new _CMSG_HDC_6017_R2();
      
        m_deqR2.add( R2Group );
        int iR2Index = (int) m_deqR2.size() - 1;
      
        // 5.1.1 GRI FOR R2.
        bIsAnotherR2 = BitOps_6017.GET_GRI( pBuffer, iDecodeBitOffset, iTotalLengthInBits );
      
        // 5.1.2.1 [FPI] URN
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_G3R2_URN_INFORMATION_ADDRESSEE;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 24, uiValue ) )
            {
              if ( PutG3R2UrnInformationAddressee( iR2Index, (int) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
        // 5.1.3.1 [FPI] UNIT LONG NAME
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_G3R2_UNIT_LONG_NAME;
            if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 448, csValue ) )
            {
              if ( PutG3R2UnitLongName( iR2Index, csValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
      } //END R2
      
    }
  } //END G3
  
  // 6.1 [FPI] HEADER SIZE
  if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
  {
    if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_HEADER_SIZE;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 16, uiValue ) )
      {
        if ( PutHeaderSize( (int) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
  }
  
  // 7.1 R3
  boolean bIsAnotherR3 = true;
  while ( ( bIsAnotherR3 ) &&
          ( iError == ERROR_MSG_HDC_6017_NO_ERROR ) &&
          ( m_deqR3.size() < MAX_MSG_HDC_6017_R3_GROUP ) )
  {
  
    _CMSG_HDC_6017_R3 R3Group = new _CMSG_HDC_6017_R3();
  
    m_deqR3.add( R3Group );
    int iR3Index = (int) m_deqR3.size() - 1;
  
    // 7.1 GRI FOR R3.  MESSAGE HANDLING GROUP.
    bIsAnotherR3 = BitOps_6017.GET_GRI( pBuffer, iDecodeBitOffset, iTotalLengthInBits );
  
    // 7.2 USER MESSAGE FORMAT CODES
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_R3_USER_MESSAGE_FORMAT_CODES;
      if ( BitOps_6017.GET_DFINO_8001_DISET_7( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, sValue ) )
      {
        if ( PutR3UserMessageFormatCodes( iR3Index, sValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
    
    // 7.3.1 [FPI] MESSAGE STANDARD VERSION
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
        iError = ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_STANDARD_VERSION;
        if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
        {
          if ( PutR3MessageStandardVersion( iR3Index, (short) uiValue[0] ) )
          {
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
      }
    }
    
    // 7.4 [GPI] GPI FOR G4.  MESSAGE IDENTIFICATION GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.4.1 FUNCTIONAL AREA DESIGNATOR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G4_FUNCTIONAL_AREA_DESIGNATOR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
          {
            if ( PutR3G4FunctionalAreaDesignator( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.4.2 MESSAGE NUMBER
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G4_MESSAGE_NUMBER;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, uiValue ) )
          {
            if ( PutR3G4MessageNumber( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.4.3.1 [FPI] MESSAGE SUBTYPE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G4_MESSAGE_SUBTYPE;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, uiValue ) )
            {
              if ( PutR3G4MessageSubtype( iR3Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
      }
    } //END G4
    
    // 7.5.1 [FPI] FILE NAME
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
        iError = ERROR_MSG_HDC_6017_DECODE_R3_FILE_NAME;
        if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 448, csValue ) )
        {
          if ( PutR3FileName( iR3Index, csValue[0] ) )
          {
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
      }
    }
    
    // 7.6.1 [FPI] MESSAGE SIZE
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
        iError = ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_SIZE;
        if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 20, uiValue ) )
        {
          if ( PutR3MessageSize( iR3Index, (int) uiValue[0] ) )
          {
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
      }
    }
    
    // 7.7 OPERATION INDICATOR
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_R3_OPERATION_INDICATOR;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 2, uiValue ) )
      {
        if ( PutR3OperationIndicator( iR3Index, (short) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
    
    // 7.8 RETRANSMIT INDICATOR
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_R3_RETRANSMIT_INDICATOR;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1, uiValue ) )
      {
        if ( PutR3RetransmitIndicator( iR3Index, (short) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
    
    // 7.9 MESSAGE PRECEDENCE CODE
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_R3_MESSAGE_PRECEDENCE_CODE;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 3, uiValue ) )
      {
        if ( PutR3MessagePrecedenceCode( iR3Index, (short) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
    
    // 7.10 SECURITY CLASSIFICATION
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      iError = ERROR_MSG_HDC_6017_DECODE_R3_SECURITY_CLASSIFICATION_;
      if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 2, uiValue ) )
      {
        if ( PutR3SecurityClassification( iR3Index, (short) uiValue[0] ) )
        {
          iError = ERROR_MSG_HDC_6017_NO_ERROR;
        }
      }
    }
    
    // 7.11.1 [FPI] CONTROL/RELEASE MARKING
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
        iError = ERROR_MSG_HDC_6017_DECODE_R3_CONTROL_RELEASE_MARKING;
        if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 224, csValue ) )
        {
          if ( PutR3ControlReleaseMarking( iR3Index, csValue[0] ) )
          {
            iError = ERROR_MSG_HDC_6017_NO_ERROR;
          }
        }
      }
    }
    
    // 7.12 [GPI] GPI FOR G5.  ORIGINATOR DATE TIME GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.12.1 YEAR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_YEAR;
          if ( BitOps_6017.GET_DFINO_4098_DISET_1( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, sValue ) )
          {
            if ( PutR3G5Year( iR3Index, sValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.2 MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
          {
            if ( PutR3G5Month( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.3 DAY OF MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_DAY_OF_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G5DayOfMonth( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.4 HOUR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_HOUR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G5Hour( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.5 MINUTE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_MINUTE;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G5Minute( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.6 SECOND
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G5_SECOND;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G5Second( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.12.7.1 [FPI] DTG EXTENSION
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G5_DTG_EXTENSION;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 12, uiValue ) )
            {
              if ( PutR3G5DtgExtension( iR3Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
      }
    } //END G5
    
    // 7.13 [GPI] GPI FOR G6.  PERISHABILITY DATE TIME GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.13.1 YEAR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_YEAR;
          if ( BitOps_6017.GET_DFINO_4098_DISET_1( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, sValue ) )
          {
            if ( PutR3G6Year( iR3Index, sValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.13.2 MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
          {
            if ( PutR3G6Month( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.13.3 DAY OF MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_DAY_OF_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G6DayOfMonth( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.13.4 HOUR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_HOUR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G6Hour( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.13.5 MINUTE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_MINUTE;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G6Minute( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.13.6 SECOND
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G6_SECOND;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G6Second( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
      }
    } //END G6
    
    // 7.14 [GPI] GPI FOR G7.  ACKNOWLEDGEMENT REQUEST GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.14.1 MACHINE ACKNOWLEDGE REQUEST
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G7_MACHINE_ACKNOWLEDGE_REQUEST;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1, uiValue ) )
          {
            if ( PutR3G7MachineAcknowledgeRequest( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.14.2 OPERATOR ACKNOWLEDGE REQUEST
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G7_OPERATOR_ACKNOWLEDGE_REQUEST;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1, uiValue ) )
          {
            if ( PutR3G7OperatorAcknowledgeRequest( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.14.3 OPERATOR REPLY REQUEST
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G7_OPERATOR_REPLY_REQUEST;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1, uiValue ) )
          {
            if ( PutR3G7OperatorReplyRequest( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
      }
    } //END G7
    
    // 7.15 [GPI] GPI FOR G8.  RESPONSE DATA GROUP.  DTG OF MESSAGE BEING ACKNOWLEDGED.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.15.1 YEAR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_YEAR;
          if ( BitOps_6017.GET_DFINO_4098_DISET_1( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, sValue ) )
          {
            if ( PutR3G8Year( iR3Index, sValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.2 MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
          {
            if ( PutR3G8Month( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.3 DAY OF MONTH
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_DAY_OF_MONTH;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G8DayOfMonth( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.4 HOUR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_HOUR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
          {
            if ( PutR3G8Hour( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.5 MINUTE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_MINUTE;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G8Minute( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.6 SECOND
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_SECOND;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
          {
            if ( PutR3G8Second( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.7.1 [FPI] DTG EXTENSION
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G8_DTG_EXTENSION;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 12, uiValue ) )
            {
              if ( PutR3G8DtgExtension( iR3Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
        // 7.15.8 RECEIPT/COMPLIANCE (R/C)
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G8_RECEIPT_COMPLIANCE_R_C;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 3, uiValue ) )
          {
            if ( PutR3G8ReceiptComplianceRC( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.15.9.1 [FPI] CANTCO REASON CODE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G8_CANTCO_REASON_CODE;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 3, uiValue ) )
            {
              if ( PutR3G8CantcoReasonCode( iR3Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
        // 7.15.10.1 [FPI] CANTPRO REASON CODE
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G8_CANTPRO_REASON_CODE;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
            {
              if ( PutR3G8CantproReasonCode( iR3Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
        // 7.15.11.1 [FPI] REPLY AMPLIFICATION
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G8_REPLY_AMPLIFICATION;
            if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 350, csValue ) )
            {
              if ( PutR3G8ReplyAmplification( iR3Index, csValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
        }
        
      }
    } //END G8
    
    // 7.16 [GPI] GPI FOR G9.  REFERENCE MESSAGE DATA GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.16.1.1 R3R4
        boolean bIsAnotherR3R4 = true;
        while ( ( bIsAnotherR3R4 ) &&
                ( iError == ERROR_MSG_HDC_6017_NO_ERROR ) &&
                ( m_deqR3.get(iR3Index).m_deqR4.size() < MAX_MSG_HDC_6017_R4_GROUP ) )
        {
        
          _CMSG_HDC_6017_R3R4 R4Group = new _CMSG_HDC_6017_R3R4();
        
          m_deqR3.get(iR3Index).m_deqR4.add( R4Group );
          int iR4Index = (int) m_deqR3.get(iR3Index).m_deqR4.size() - 1;
        
          // 7.16.1.1 GRI FOR R4.
          bIsAnotherR3R4 = BitOps_6017.GET_GRI( pBuffer, iDecodeBitOffset, iTotalLengthInBits );
        
          // 7.16.1.2.1 [FPI] URN
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_URN_;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 24, uiValue ) )
              {
                if ( PutR3G9R4Urn( iR3Index, iR4Index, (int) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
          }
          
          // 7.16.1.3.1 [FPI] UNIT LONG NAME
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_UNIT_LONG_NAME;
              if ( BitOps_6017.GET_ASCII_TEXT( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 448, csValue ) )
              {
                if ( PutR3G9R4UnitLongName( iR3Index, iR4Index, csValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
          }
          
          // 7.16.1.4 YEAR
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_YEAR;
            if ( BitOps_6017.GET_DFINO_4098_DISET_1( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, sValue ) )
            {
              if ( PutR3G9R4Year( iR3Index, iR4Index, sValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.5 MONTH
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_MONTH;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
            {
              if ( PutR3G9R4Month( iR3Index, iR4Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.6 DAY OF MONTH
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_DAY_OF_MONTH;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
            {
              if ( PutR3G9R4DayOfMonth( iR3Index, iR4Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.7 HOUR
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_HOUR;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 5, uiValue ) )
            {
              if ( PutR3G9R4Hour( iR3Index, iR4Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.8 MINUTE
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_MINUTE;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
            {
              if ( PutR3G9R4Minute( iR3Index, iR4Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.9 SECOND
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_SECOND;
            if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 6, uiValue ) )
            {
              if ( PutR3G9R4Second( iR3Index, iR4Index, (short) uiValue[0] ) )
              {
                iError = ERROR_MSG_HDC_6017_NO_ERROR;
              }
            }
          }
          
          // 7.16.1.10.1 [FPI] DTG EXTENSION
          if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
          {
            if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G9R4_DTG_EXTENSION;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 12, uiValue ) )
              {
                if ( PutR3G9R4DtgExtension( iR3Index, iR4Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
          }
          
        } //END R4
        
      }
    } //END G9
    
    // 7.17 [GPI] GPI FOR G10.  MESSAGE SECURITY GROUP.
    if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
    {
      if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
      {
    
        // 7.17.1 SECURITY PARAMETERS INFORMATION (SPI)
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G10_SECURITY_PARAMETERS_INFORMATION_SPI;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
          {
            if ( PutR3G10SecurityParametersInformationSpi( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.17.2 [GPI] GPI FOR G11.  KEYING MATERIAL GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.2.1 KEYING MATERIAL ID LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G11_KEYING_MATERIAL_ID_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 3, uiValue ) )
              {
                if ( PutR3G10G11KeyingMaterialIdLength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.2.2 KEYING MATERIAL ID
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G11_KEYING_MATERIAL_ID;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 64, uiValue ) )
              {
                if ( PutR3G10G11KeyingMaterialId( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
          }
        } //END G11
        
        // 7.17.3 [GPI] GPI FOR G12.  CRYPTOGRAPHIC INITIALIZATION GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.3.1 CRYPTOGRAPHIC INITIALIZATION LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 4, uiValue ) )
              {
                if ( PutR3G10G12CryptographicInitializationLength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.3.2 CRYPTOGRAPHIC INITIALIZATION
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G12_CRYPTOGRAPHIC_INITIALIZATION;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1024, uiValue ) )
              {
                if ( PutR3G10G12CryptographicInitialization( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
          }
        } //END G12
        
        // 7.17.4 [GPI] GPI FOR G13.  KEY TOKEN GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.4.1 KEY TOKEN LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G13_KEY_TOKEN_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 8, uiValue ) )
              {
                if ( PutR3G10G13KeyTokenLength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.4.2.1 R3R5
            boolean bIsAnotherR3R5 = true;
            while ( ( bIsAnotherR3R5 ) &&
                    ( iError == ERROR_MSG_HDC_6017_NO_ERROR ) &&
                    ( m_deqR3.get(iR3Index).m_deqR5.size() < MAX_MSG_HDC_6017_R5_GROUP ) )
            {
            
              _CMSG_HDC_6017_R3R5 R5Group = new _CMSG_HDC_6017_R3R5();
            
              m_deqR3.get(iR3Index).m_deqR5.add( R5Group );
              int iR5Index = (int) m_deqR3.get(iR3Index).m_deqR5.size() - 1;
            
              // 7.17.4.2.1 
              bIsAnotherR3R5 = BitOps_6017.GET_GRI( pBuffer, iDecodeBitOffset, iTotalLengthInBits );
            
              // 7.17.4.2.2 KEY TOKEN
              if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
              {
                iError = ERROR_MSG_HDC_6017_DECODE_R3G10G13R5_KEY_TOKEN;
                if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 16384, uiValue ) )
                {
                  if ( PutR3G10G13R5KeyToken( iR3Index, iR5Index, (short) uiValue[0] ) )
                  {
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
              }
              
            } //END R5
            
          }
        } //END G13
        
        // 7.17.5 [GPI] GPI FOR G14.  AUTHENTICATION (A) GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.5.1 AUTHENTICATION DATA (A) LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G14_AUTHENTICATION_DATA_A_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, uiValue ) )
              {
                if ( PutR3G10G14AuthenticationDataALength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.5.2 AUTHENTICATION DATA (A)
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G14_AUTHENTICATION_DATA_A;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 8192, uiValue ) )
              {
                if ( PutR3G10G14AuthenticationDataA( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
          }
        } //END G14
        
        // 7.17.6 [GPI] GPI FOR G15.  AUTHENTICATION (B) GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.6.1 AUTHENTICATION DATA (B) LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G15_AUTHENTICATION_DATA_B_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 7, uiValue ) )
              {
                if ( PutR3G10G15AuthenticationDataBLength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.6.2 AUTHENTICATION DATA (B)
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G15_AUTHENTICATION_DATA_B;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 8192, uiValue ) )
              {
                if ( PutR3G10G15AuthenticationDataB( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
          }
        } //END G15
        
        // 7.17.7 SIGNED ACKNOWLEDGE REQUEST INDICATOR
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          iError = ERROR_MSG_HDC_6017_DECODE_R3G10_SIGNED_ACKNOWLEDGE_REQUEST_INDICATOR;
          if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 1, uiValue ) )
          {
            if ( PutR3G10SignedAcknowledgeRequestIndicator( iR3Index, (short) uiValue[0] ) )
            {
              iError = ERROR_MSG_HDC_6017_NO_ERROR;
            }
          }
        }
        
        // 7.17.8 [GPI] GPI FOR G16.  MESSAGE SECURITY PADDING GROUP.
        if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
        {
          if ( BitOps_6017.GET_GPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
          {
        
            // 7.17.8.1 MESSAGE SECURITY PADDING LENGTH
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              iError = ERROR_MSG_HDC_6017_DECODE_R3G10G16_MESSAGE_SECURITY_PADDING_LENGTH;
              if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 8, uiValue ) )
              {
                if ( PutR3G10G16MessageSecurityPaddingLength( iR3Index, (short) uiValue[0] ) )
                {
                  iError = ERROR_MSG_HDC_6017_NO_ERROR;
                }
              }
            }
            
            // 7.17.8.2.1 [FPI] MESSAGE SECURITY PADDING
            if ( iError == ERROR_MSG_HDC_6017_NO_ERROR )
            {
              if ( BitOps_6017.GET_FPI( pBuffer, iDecodeBitOffset, iTotalLengthInBits ) )
              {
                iError = ERROR_MSG_HDC_6017_DECODE_R3G10G16_MESSAGE_SECURITY_PADDING;
                if ( BitOps_6017.GET_BIT_VALUE( pBuffer, iDecodeBitOffset, iTotalLengthInBits, 2040, uiValue ) )
                {
                  if ( PutR3G10G16MessageSecurityPadding( iR3Index, (short) uiValue[0] ) )
                  {
                    iError = ERROR_MSG_HDC_6017_NO_ERROR;
                  }
                }
              }
            }
            
          }
        } //END G16
        
      }
    } //END G10
    
  } //END R3
  
  m_iDecodeBitOffset = iDecodeBitOffset[0]; 
  return iError;

} // End Decode Message

public boolean IsG1GroupPresent()
{
  boolean bIsPresent = true;

  if ( m_iG1UrnOriginator == -1 &&
       m_strG1UnitLongName == "" )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG2GroupPresent()
{
  boolean bIsPresent = true;

  if ( m_deqR1.size() == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG3GroupPresent()
{
  boolean bIsPresent = true;

  if ( m_deqR2.size() == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG4GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator == -1 &&
       m_deqR3.get(iR3Index).m_sR3G4MessageNumber == -1 &&
       m_deqR3.get(iR3Index).m_sR3G4MessageSubtype == -1 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG5GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G5Year == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5Month == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5DayOfMonth == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5Hour == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5Minute == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5Second == -1 &&
       m_deqR3.get(iR3Index).m_sR3G5DtgExtension == -1 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG6GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G6Year == -1 &&
       m_deqR3.get(iR3Index).m_sR3G6Month == -1 &&
       m_deqR3.get(iR3Index).m_sR3G6DayOfMonth == -1 &&
       m_deqR3.get(iR3Index).m_sR3G6Hour == -1 &&
       m_deqR3.get(iR3Index).m_sR3G6Minute == -1 &&
       m_deqR3.get(iR3Index).m_sR3G6Second == -1 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG7GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest == -1 &&
       m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest == -1 &&
       m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest == -1 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG8GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G8Year == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8Month == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8DayOfMonth == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8Hour == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8Minute == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8Second == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8DtgExtension == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode == -1 &&
       m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode == -1 &&
       m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification == "" )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG9GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_deqR4.size() == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG10GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi == -1 &&
       !IsG11GroupPresent(iR3Index) &&
       !IsG12GroupPresent(iR3Index) &&
       !IsG13GroupPresent(iR3Index) &&
       !IsG14GroupPresent(iR3Index) &&
       !IsG15GroupPresent(iR3Index) &&
       m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator == -1 &&
       !IsG16GroupPresent(iR3Index) )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG11GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength == -1 &&
       m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG12GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength == -1 &&
       m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG13GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength == -1 &&
       m_deqR3.get(iR3Index).m_deqR5.size() == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG14GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength == -1 &&
       m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG15GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength == -1 &&
       m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

public boolean IsG16GroupPresent( int iR3Index )
{
  boolean bIsPresent = false;

  if ( (int) m_deqR3.size() > iR3Index )
  {
    bIsPresent = true;
  }

  if ( bIsPresent &&
       m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength == -1 &&
       m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding == 0 )
  {
    bIsPresent = false;
  }
  
  return bIsPresent;
}

// 1.
public boolean PutVersion( short sValue )
{
  boolean bIsValid = false;
  if ( VmfOps_6017.IS_VALID_DFINO_8001_DISET_6( sValue ) )
  {
    m_sVersion = sValue;
    bIsValid = true;
  }
  else
  {
    m_sVersion = -1;
  }
  return bIsValid;
}
public short GetVersion()
{
  short sValue = -1;
  sValue = m_sVersion;
  return sValue;
}

// 2.1
public boolean PutDataCompressionType( short sValue )
{
  boolean bIsValid = false;
  if ( VmfOps_6017.IS_VALID_DFINO_8001_DISET_2( sValue ) )
  {
    m_sDataCompressionType = sValue;
    bIsValid = true;
  }
  else
  {
    m_sDataCompressionType = -1;
  }
  return bIsValid;
}
public short GetDataCompressionType()
{
  short sValue = -1;
  sValue = m_sDataCompressionType;
  return sValue;
}

// 3.1.1
public boolean PutG1UrnOriginator( int iValue )
{
  boolean bIsValid = false;
  if ( VmfOps_6017.IS_VALID_DFINO_4004_DISET_2( iValue ) )
  {
    m_iG1UrnOriginator = iValue;
    bIsValid = true;
  }
  else
  {
    m_iG1UrnOriginator = -1;
  }
  return bIsValid;
}
public int GetG1UrnOriginator()
{
  int iValue = -1;
  iValue = m_iG1UrnOriginator;
  return iValue;
}

// 3.2.1
public boolean PutG1UnitLongName( String strValue )
{
  boolean bIsValid = false;
  if ( VmfOps_6017.IS_VALID_DFINO_4004_DISET_3( strValue ) )
  {
    m_strG1UnitLongName = strValue;
    bIsValid = true;
  }
  else
  {
    m_strG1UnitLongName = "";
  }
  return bIsValid;
}
public String GetG1UnitLongName()
{
  String strValue = "";
  strValue = m_strG1UnitLongName;
  return strValue;
}

// 4.1.2.1
public boolean PutG2R1UrnRecipient( int iR1Index, int iValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR1.size() > iR1Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_2( iValue ) )
  {
    m_deqR1.get(iR1Index).m_iG2R1UrnRecipient = iValue;
    bIsValid = true;
  }
  else
  {
    m_deqR1.get(iR1Index).m_iG2R1UrnRecipient = -1;
  }
  return bIsValid;
}
public int GetG2R1UrnRecipient( int iR1Index )
{
  int iValue = -1;
  if ( (int) m_deqR1.size() > iR1Index  )
  {
    iValue = m_deqR1.get(iR1Index).m_iG2R1UrnRecipient;
  }
  return iValue;
}

// 4.1.3.1
public boolean PutG2R1UnitLongName( int iR1Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR1.size() > iR1Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_3( strValue ) )
  {
    m_deqR1.get(iR1Index).m_strG2R1UnitLongName = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR1.get(iR1Index).m_strG2R1UnitLongName = "";
  }
  return bIsValid;
}
public String GetG2R1UnitLongName( int iR1Index )
{
  String strValue = "";
  if ( (int) m_deqR1.size() > iR1Index  )
  {
    strValue = m_deqR1.get(iR1Index).m_strG2R1UnitLongName;
  }
  return strValue;
}

// 5.1.2.1
public boolean PutG3R2UrnInformationAddressee( int iR2Index, int iValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR2.size() > iR2Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_2( iValue ) )
  {
    m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee = iValue;
    bIsValid = true;
  }
  else
  {
    m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee = -1;
  }
  return bIsValid;
}
public int GetG3R2UrnInformationAddressee( int iR2Index )
{
  int iValue = -1;
  if ( (int) m_deqR2.size() > iR2Index  )
  {
    iValue = m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee;
  }
  return iValue;
}

// 5.1.3.1
public boolean PutG3R2UnitLongName( int iR2Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR2.size() > iR2Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_3( strValue ) )
  {
    m_deqR2.get(iR2Index).m_strG3R2UnitLongName = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR2.get(iR2Index).m_strG3R2UnitLongName = "";
  }
  return bIsValid;
}
public String GetG3R2UnitLongName( int iR2Index )
{
  String strValue = "";
  if ( (int) m_deqR2.size() > iR2Index  )
  {
    strValue = m_deqR2.get(iR2Index).m_strG3R2UnitLongName;
  }
  return strValue;
}

// 6.1
public boolean PutHeaderSize( int iValue )
{
  boolean bIsValid = false;
  if ( VmfOps_6017.IS_VALID_DFINO_8005_DISET_4( iValue ) )
  {
    m_iHeaderSize = iValue;
    bIsValid = true;
  }
  else
  {
    m_iHeaderSize = -1;
  }
  return bIsValid;
}
public int GetHeaderSize()
{
  int iValue = -1;
  iValue = m_iHeaderSize;
  return iValue;
}

// 7.2
public boolean PutR3UserMessageFormatCodes( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8001_DISET_7( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes = -1;
  }
  return bIsValid;
}
public short GetR3UserMessageFormatCodes( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes;
  }
  return sValue;
}

// 7.3.1
public boolean PutR3MessageStandardVersion( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8001_DISET_8( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3MessageStandardVersion = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3MessageStandardVersion = -1;
  }
  return bIsValid;
}
public short GetR3MessageStandardVersion( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3MessageStandardVersion;
  }
  return sValue;
}

// 7.4.1
public boolean PutR3G4FunctionalAreaDesignator( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8001_DISET_4( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator = -1;
  }
  return bIsValid;
}
public short GetR3G4FunctionalAreaDesignator( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator;
  }
  return sValue;
}

// 7.4.2
public boolean PutR3G4MessageNumber( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8005_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G4MessageNumber = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G4MessageNumber = -1;
  }
  return bIsValid;
}
public short GetR3G4MessageNumber( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G4MessageNumber;
  }
  return sValue;
}

// 7.4.3.1
public boolean PutR3G4MessageSubtype( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8001_DISET_9( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G4MessageSubtype = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G4MessageSubtype = -1;
  }
  return bIsValid;
}
public short GetR3G4MessageSubtype( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G4MessageSubtype;
  }
  return sValue;
}

// 7.5.1
public boolean PutR3FileName( int iR3Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8006_DISET_1( strValue ) )
  {
    m_deqR3.get(iR3Index).m_strR3FileName = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_strR3FileName = "";
  }
  return bIsValid;
}
public String GetR3FileName( int iR3Index )
{
  String strValue = "";
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    strValue = m_deqR3.get(iR3Index).m_strR3FileName;
  }
  return strValue;
}

// 7.6.1
public boolean PutR3MessageSize( int iR3Index, int iValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8005_DISET_2( iValue ) )
  {
    m_deqR3.get(iR3Index).m_iR3MessageSize = iValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_iR3MessageSize = -1;
  }
  return bIsValid;
}
public int GetR3MessageSize( int iR3Index )
{
  int iValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    iValue = m_deqR3.get(iR3Index).m_iR3MessageSize;
  }
  return iValue;
}

// 7.7
public boolean PutR3OperationIndicator( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8001_DISET_5( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3OperationIndicator = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3OperationIndicator = -1;
  }
  return bIsValid;
}
public short GetR3OperationIndicator( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3OperationIndicator;
  }
  return sValue;
}

// 7.8
public boolean PutR3RetransmitIndicator( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8007_DISET_4( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3RetransmitIndicator = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3RetransmitIndicator = -1;
  }
  return bIsValid;
}
public short GetR3RetransmitIndicator( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3RetransmitIndicator;
  }
  return sValue;
}

// 7.9
public boolean PutR3MessagePrecedenceCode( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8002_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode = -1;
  }
  return bIsValid;
}
public short GetR3MessagePrecedenceCode( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode;
  }
  return sValue;
}

// 7.10
public boolean PutR3SecurityClassification( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8002_DISET_2( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3SecurityClassification = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3SecurityClassification = -1;
  }
  return bIsValid;
}
public short GetR3SecurityClassification( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3SecurityClassification;
  }
  return sValue;
}

// 7.11.1
public boolean PutR3ControlReleaseMarking( int iR3Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8002_DISET_4( strValue ) )
  {
    m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking = "";
  }
  return bIsValid;
}
public String GetR3ControlReleaseMarking( int iR3Index )
{
  String strValue = "";
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    strValue = m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking;
  }
  return strValue;
}

// 7.12.1
public boolean PutR3G5Year( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4098_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5Year = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5Year = -1;
  }
  return bIsValid;
}
public short GetR3G5Year( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5Year;
  }
  return sValue;
}

// 7.12.2
public boolean PutR3G5Month( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4099_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5Month = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5Month = -1;
  }
  return bIsValid;
}
public short GetR3G5Month( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5Month;
  }
  return sValue;
}

// 7.12.3
public boolean PutR3G5DayOfMonth( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4019_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5DayOfMonth = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5DayOfMonth = -1;
  }
  return bIsValid;
}
public short GetR3G5DayOfMonth( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5DayOfMonth;
  }
  return sValue;
}

// 7.12.4
public boolean PutR3G5Hour( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_792_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5Hour = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5Hour = -1;
  }
  return bIsValid;
}
public short GetR3G5Hour( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5Hour;
  }
  return sValue;
}

// 7.12.5
public boolean PutR3G5Minute( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_797_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5Minute = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5Minute = -1;
  }
  return bIsValid;
}
public short GetR3G5Minute( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5Minute;
  }
  return sValue;
}

// 7.12.6
public boolean PutR3G5Second( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_380_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5Second = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5Second = -1;
  }
  return bIsValid;
}
public short GetR3G5Second( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5Second;
  }
  return sValue;
}

// 7.12.7.1
public boolean PutR3G5DtgExtension( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8005_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G5DtgExtension = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G5DtgExtension = -1;
  }
  return bIsValid;
}
public short GetR3G5DtgExtension( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G5DtgExtension;
  }
  return sValue;
}

// 7.13.1
public boolean PutR3G6Year( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4098_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6Year = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6Year = -1;
  }
  return bIsValid;
}
public short GetR3G6Year( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6Year;
  }
  return sValue;
}

// 7.13.2
public boolean PutR3G6Month( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4099_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6Month = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6Month = -1;
  }
  return bIsValid;
}
public short GetR3G6Month( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6Month;
  }
  return sValue;
}

// 7.13.3
public boolean PutR3G6DayOfMonth( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4019_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6DayOfMonth = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6DayOfMonth = -1;
  }
  return bIsValid;
}
public short GetR3G6DayOfMonth( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6DayOfMonth;
  }
  return sValue;
}

// 7.13.4
public boolean PutR3G6Hour( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_792_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6Hour = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6Hour = -1;
  }
  return bIsValid;
}
public short GetR3G6Hour( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6Hour;
  }
  return sValue;
}

// 7.13.5
public boolean PutR3G6Minute( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_797_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6Minute = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6Minute = -1;
  }
  return bIsValid;
}
public short GetR3G6Minute( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6Minute;
  }
  return sValue;
}

// 7.13.6
public boolean PutR3G6Second( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_380_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G6Second = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G6Second = -1;
  }
  return bIsValid;
}
public short GetR3G6Second( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G6Second;
  }
  return sValue;
}

// 7.14.1
public boolean PutR3G7MachineAcknowledgeRequest( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8007_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest = -1;
  }
  return bIsValid;
}
public short GetR3G7MachineAcknowledgeRequest( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest;
  }
  return sValue;
}

// 7.14.2
public boolean PutR3G7OperatorAcknowledgeRequest( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8007_DISET_2( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest = -1;
  }
  return bIsValid;
}
public short GetR3G7OperatorAcknowledgeRequest( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest;
  }
  return sValue;
}

// 7.14.3
public boolean PutR3G7OperatorReplyRequest( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8007_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest = -1;
  }
  return bIsValid;
}
public short GetR3G7OperatorReplyRequest( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest;
  }
  return sValue;
}

// 7.15.1
public boolean PutR3G8Year( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4098_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8Year = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8Year = -1;
  }
  return bIsValid;
}
public short GetR3G8Year( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8Year;
  }
  return sValue;
}

// 7.15.2
public boolean PutR3G8Month( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4099_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8Month = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8Month = -1;
  }
  return bIsValid;
}
public short GetR3G8Month( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8Month;
  }
  return sValue;
}

// 7.15.3
public boolean PutR3G8DayOfMonth( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_4019_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8DayOfMonth = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8DayOfMonth = -1;
  }
  return bIsValid;
}
public short GetR3G8DayOfMonth( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8DayOfMonth;
  }
  return sValue;
}

// 7.15.4
public boolean PutR3G8Hour( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_792_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8Hour = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8Hour = -1;
  }
  return bIsValid;
}
public short GetR3G8Hour( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8Hour;
  }
  return sValue;
}

// 7.15.5
public boolean PutR3G8Minute( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_797_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8Minute = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8Minute = -1;
  }
  return bIsValid;
}
public short GetR3G8Minute( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8Minute;
  }
  return sValue;
}

// 7.15.6
public boolean PutR3G8Second( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_380_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8Second = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8Second = -1;
  }
  return bIsValid;
}
public short GetR3G8Second( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8Second;
  }
  return sValue;
}

// 7.15.7.1
public boolean PutR3G8DtgExtension( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8005_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8DtgExtension = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8DtgExtension = -1;
  }
  return bIsValid;
}
public short GetR3G8DtgExtension( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8DtgExtension;
  }
  return sValue;
}

// 7.15.8
public boolean PutR3G8ReceiptComplianceRC( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8003_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC = -1;
  }
  return bIsValid;
}
public short GetR3G8ReceiptComplianceRC( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC;
  }
  return sValue;
}

// 7.15.9.1
public boolean PutR3G8CantcoReasonCode( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8003_DISET_2( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode = -1;
  }
  return bIsValid;
}
public short GetR3G8CantcoReasonCode( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode;
  }
  return sValue;
}

// 7.15.10.1
public boolean PutR3G8CantproReasonCode( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8003_DISET_4( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode = -1;
  }
  return bIsValid;
}
public short GetR3G8CantproReasonCode( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode;
  }
  return sValue;
}

// 7.15.11.1
public boolean PutR3G8ReplyAmplification( int iR3Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8004_DISET_1( strValue ) )
  {
    m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification = "";
  }
  return bIsValid;
}
public String GetR3G8ReplyAmplification( int iR3Index )
{
  String strValue = "";
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    strValue = m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification;
  }
  return strValue;
}

// 7.16.1.2.1
public boolean PutR3G9R4Urn( int iR3Index, int iR4Index, int iValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_2( iValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn = iValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn = -1;
  }
  return bIsValid;
}
public int GetR3G9R4Urn( int iR3Index, int iR4Index )
{
  int iValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    iValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn;
  }
  return iValue;
}

// 7.16.1.3.1
public boolean PutR3G9R4UnitLongName( int iR3Index, int iR4Index, String strValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_4004_DISET_3( strValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName = strValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName = "";
  }
  return bIsValid;
}
public String GetR3G9R4UnitLongName( int iR3Index, int iR4Index )
{
  String strValue = "";
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    strValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName;
  }
  return strValue;
}

// 7.16.1.4
public boolean PutR3G9R4Year( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_4098_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year = -1;
  }
  return bIsValid;
}
public short GetR3G9R4Year( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year;
  }
  return sValue;
}

// 7.16.1.5
public boolean PutR3G9R4Month( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_4099_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month = -1;
  }
  return bIsValid;
}
public short GetR3G9R4Month( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month;
  }
  return sValue;
}

// 7.16.1.6
public boolean PutR3G9R4DayOfMonth( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_4019_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth = -1;
  }
  return bIsValid;
}
public short GetR3G9R4DayOfMonth( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth;
  }
  return sValue;
}

// 7.16.1.7
public boolean PutR3G9R4Hour( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_792_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour = -1;
  }
  return bIsValid;
}
public short GetR3G9R4Hour( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour;
  }
  return sValue;
}

// 7.16.1.8
public boolean PutR3G9R4Minute( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_797_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute = -1;
  }
  return bIsValid;
}
public short GetR3G9R4Minute( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute;
  }
  return sValue;
}

// 7.16.1.9
public boolean PutR3G9R4Second( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_380_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second = -1;
  }
  return bIsValid;
}
public short GetR3G9R4Second( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second;
  }
  return sValue;
}

// 7.16.1.10.1
public boolean PutR3G9R4DtgExtension( int iR3Index, int iR4Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index &&
       VmfOps_6017.IS_VALID_DFINO_8005_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension = -1;
  }
  return bIsValid;
}
public short GetR3G9R4DtgExtension( int iR3Index, int iR4Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() > iR4Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension;
  }
  return sValue;
}

// 7.17.1
public boolean PutR3G10SecurityParametersInformationSpi( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi = -1;
  }
  return bIsValid;
}
public short GetR3G10SecurityParametersInformationSpi( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi;
  }
  return sValue;
}

// 7.17.2.1
public boolean PutR3G10G11KeyingMaterialIdLength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_1( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength = -1;
  }
  return bIsValid;
}
public short GetR3G10G11KeyingMaterialIdLength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength;
  }
  return sValue;
}

// 7.17.2.2
public boolean PutR3G10G11KeyingMaterialId( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_2( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId = 0;
  }
  return bIsValid;
}
public short GetR3G10G11KeyingMaterialId( int iR3Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId;
  }
  return sValue;
}

// 7.17.3.1
public boolean PutR3G10G12CryptographicInitializationLength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_2( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength = -1;
  }
  return bIsValid;
}
public short GetR3G10G12CryptographicInitializationLength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength;
  }
  return sValue;
}

// 7.17.3.2
public boolean PutR3G10G12CryptographicInitialization( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization = 0;
  }
  return bIsValid;
}
public short GetR3G10G12CryptographicInitialization( int iR3Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization;
  }
  return sValue;
}

// 7.17.4.1
public boolean PutR3G10G13KeyTokenLength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_3( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength = -1;
  }
  return bIsValid;
}
public short GetR3G10G13KeyTokenLength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength;
  }
  return sValue;
}

// 7.17.4.2.2
public boolean PutR3G10G13R5KeyToken( int iR3Index, int iR5Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR5.size() > iR5Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_4( sValue ) )
  {
    m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken = 0;
  }
  return bIsValid;
}
public short GetR3G10G13R5KeyToken( int iR3Index, int iR5Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR5.size() > iR5Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken;
  }
  return sValue;
}

// 7.17.5.1
public boolean PutR3G10G14AuthenticationDataALength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_4( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength = -1;
  }
  return bIsValid;
}
public short GetR3G10G14AuthenticationDataALength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength;
  }
  return sValue;
}

// 7.17.5.2
public boolean PutR3G10G14AuthenticationDataA( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_5( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA = 0;
  }
  return bIsValid;
}
public short GetR3G10G14AuthenticationDataA( int iR3Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA;
  }
  return sValue;
}

// 7.17.6.1
public boolean PutR3G10G15AuthenticationDataBLength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_5( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength = -1;
  }
  return bIsValid;
}
public short GetR3G10G15AuthenticationDataBLength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength;
  }
  return sValue;
}

// 7.17.6.2
public boolean PutR3G10G15AuthenticationDataB( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_6( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB = 0;
  }
  return bIsValid;
}
public short GetR3G10G15AuthenticationDataB( int iR3Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB;
  }
  return sValue;
}

// 7.17.7
public boolean PutR3G10SignedAcknowledgeRequestIndicator( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_7( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator = -1;
  }
  return bIsValid;
}
public short GetR3G10SignedAcknowledgeRequestIndicator( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator;
  }
  return sValue;
}

// 7.17.8.1
public boolean PutR3G10G16MessageSecurityPaddingLength( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8009_DISET_6( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength = -1;
  }
  return bIsValid;
}
public short GetR3G10G16MessageSecurityPaddingLength( int iR3Index )
{
  short sValue = -1;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength;
  }
  return sValue;
}

// 7.17.8.2.1
public boolean PutR3G10G16MessageSecurityPadding( int iR3Index, short sValue )
{
  boolean bIsValid = false;
  if ( (int) m_deqR3.size() > iR3Index &&
       VmfOps_6017.IS_VALID_DFINO_8008_DISET_8( sValue ) )
  {
    m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding = sValue;
    bIsValid = true;
  }
  else
  {
    m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding = 0;
  }
  return bIsValid;
}
public short GetR3G10G16MessageSecurityPadding( int iR3Index )
{
  short sValue = 0;
  if ( (int) m_deqR3.size() > iR3Index  )
  {
    sValue = m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding;
  }
  return sValue;
}

public int AddR1RepeatGroup()
{
  int iR1Index = -1;
  if ( (int) m_deqR1.size() < MAX_MSG_HDC_6017_R1_GROUP )
  {
    _CMSG_HDC_6017_R1 R1Group = new _CMSG_HDC_6017_R1();
    m_deqR1.add( R1Group );
    iR1Index = (int) m_deqR1.size() - 1;
  }
  return iR1Index;
}

public void ClearR1RepeatGroup()
{
  m_deqR1.clear();
}

public int GetR1RepeatGroupSize()
{
  int iR1Size = 0;
  iR1Size = (int) m_deqR1.size();
  return iR1Size;
}

public int AddR2RepeatGroup()
{
  int iR2Index = -1;
  if ( (int) m_deqR2.size() < MAX_MSG_HDC_6017_R2_GROUP )
  {
    _CMSG_HDC_6017_R2 R2Group = new _CMSG_HDC_6017_R2();
    m_deqR2.add( R2Group );
    iR2Index = (int) m_deqR2.size() - 1;
  }
  return iR2Index;
}

public void ClearR2RepeatGroup()
{
  m_deqR2.clear();
}

public int GetR2RepeatGroupSize()
{
  int iR2Size = 0;
  iR2Size = (int) m_deqR2.size();
  return iR2Size;
}

public int AddR3RepeatGroup()
{
  int iR3Index = -1;
  if ( (int) m_deqR3.size() < MAX_MSG_HDC_6017_R3_GROUP )
  {
    _CMSG_HDC_6017_R3 R3Group = new _CMSG_HDC_6017_R3();
    m_deqR3.add( R3Group );
    iR3Index = (int) m_deqR3.size() - 1;
  }
  return iR3Index;
}

public void ClearR3RepeatGroup()
{
  m_deqR3.clear();
}

public int GetR3RepeatGroupSize()
{
  int iR3Size = 0;
  iR3Size = (int) m_deqR3.size();
  return iR3Size;
}

public int AddR3R4RepeatGroup( int iR3Index )
{
  int iR4Index = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR4.size() < MAX_MSG_HDC_6017_R4_GROUP )
  {
    _CMSG_HDC_6017_R3R4 R4Group = new _CMSG_HDC_6017_R3R4();
    m_deqR3.get(iR3Index).m_deqR4.add( R4Group );
    iR4Index = (int) m_deqR3.get(iR3Index).m_deqR4.size() - 1;
  }
  return iR4Index;
}

public void ClearR3R4RepeatGroup( int iR3Index )
{
  if ( (int) m_deqR3.size() > iR3Index )
  {
    m_deqR3.get(iR3Index).m_deqR4.clear();
  }
}

public int GetR3R4RepeatGroupSize( int iR3Index )
{
  int iR4Size = 0;
  if ( (int) m_deqR3.size() > iR3Index )
  {
    iR4Size = (int) m_deqR3.get(iR3Index).m_deqR4.size();
  }
  return iR4Size;
}

public int AddR3R5RepeatGroup( int iR3Index )
{
  int iR5Index = -1;
  if ( (int) m_deqR3.size() > iR3Index &&
       (int) m_deqR3.get(iR3Index).m_deqR5.size() < MAX_MSG_HDC_6017_R5_GROUP )
  {
    _CMSG_HDC_6017_R3R5 R5Group = new _CMSG_HDC_6017_R3R5();
    m_deqR3.get(iR3Index).m_deqR5.add( R5Group );
    iR5Index = (int) m_deqR3.get(iR3Index).m_deqR5.size() - 1;
  }
  return iR5Index;
}

public void ClearR3R5RepeatGroup( int iR3Index )
{
  if ( (int) m_deqR3.size() > iR3Index )
  {
    m_deqR3.get(iR3Index).m_deqR5.clear();
  }
}

public int GetR3R5RepeatGroupSize( int iR3Index )
{
  int iR5Size = 0;
  if ( (int) m_deqR3.size() > iR3Index )
  {
    iR5Size = (int) m_deqR3.get(iR3Index).m_deqR5.size();
  }
  return iR5Size;
}

public String GetTranslatedMessageString()
{
  String strTmp = "";
  String strMsg = "";
  int iSymbolDimension = -1; 
  int iEntityType = -1; 

  // 1. VERSION
  if ( m_sVersion != -1 )
  {
    strTmp = "Version: " + m_sVersion + "\r\n";
    strMsg += strTmp;
  }
  
  // [FPI] 2.1 DATA COMPRESSION TYPE
  if ( m_sDataCompressionType != -1 )
  {
    strTmp = "Data Compression Type: " + m_sDataCompressionType + "\r\n";
    strMsg += strTmp;
  }
  
  if ( IsG1GroupPresent() )
  {
    strMsg += "- ORIGINATOR ADDRESS GROUP - G1 -\r\n";
  
    // [FPI] 3.1.1 URN
    if ( m_iG1UrnOriginator != -1 )
    {
      strTmp = "  Urn Orig: " + m_iG1UrnOriginator + "\r\n";
      strMsg += strTmp;
    }
    
    // [FPI] 3.2.1 UNIT LONG NAME
    if ( m_strG1UnitLongName != "" )
    {
      strTmp = "  Unit Long Name: " + m_strG1UnitLongName + "\r\n";
      strMsg += strTmp;
    }
    
  } //END G1
  
  if ( IsG2GroupPresent() )
  {
    strMsg += "- RECIPIENT ADDRESS GROUP - G2 -\r\n";
  
    // R1
    int iR1Size = (int) m_deqR1.size();
    for ( int iR1Index = 0; iR1Index < iR1Size; iR1Index++ )
    {
      strTmp = "   === R1 [" + String.format("%d", iR1Index + 1) + " of " + String.format("%d] ===\r\n", iR1Size);
      strMsg += strTmp;
    
      // [FPI] 4.1.2.1 URN
      if ( m_deqR1.get(iR1Index).m_iG2R1UrnRecipient != -1 )
      {
        strTmp = "    Urn Recipient: " + m_deqR1.get(iR1Index).m_iG2R1UrnRecipient + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 4.1.3.1 UNIT LONG NAME
      if ( m_deqR1.get(iR1Index).m_strG2R1UnitLongName != "" )
      {
        strTmp = "    Unit Long Name: " + m_deqR1.get(iR1Index).m_strG2R1UnitLongName + "\r\n";
        strMsg += strTmp;
      }
      
    } //END R1
    
  } //END G2
  
  if ( IsG3GroupPresent() )
  {
    strMsg += "- INFORMATION ADDRESS GROUP - G3 -\r\n";
  
    // R2
    int iR2Size = (int) m_deqR2.size();
    for ( int iR2Index = 0; iR2Index < iR2Size; iR2Index++ )
    {
      strTmp = "   === R2 [" + String.format("%d", iR2Index + 1) + " of " + String.format("%d] ===\r\n", iR2Size);
      strMsg += strTmp;
    
      // [FPI] 5.1.2.1 URN
      if ( m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee != -1 )
      {
        strTmp = "    Urn Information Addressee: " + m_deqR2.get(iR2Index).m_iG3R2UrnInformationAddressee + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 5.1.3.1 UNIT LONG NAME
      if ( m_deqR2.get(iR2Index).m_strG3R2UnitLongName != "" )
      {
        strTmp = "    Unit Long Name: " + m_deqR2.get(iR2Index).m_strG3R2UnitLongName + "\r\n";
        strMsg += strTmp;
      }
      
    } //END R2
    
  } //END G3
  
  // [FPI] 6.1 HEADER SIZE
  if ( m_iHeaderSize != -1 )
  {
    strTmp = "Header Size: " + m_iHeaderSize + "\r\n";
    strMsg += strTmp;
  }
  
  // R3
  int iR3Size = (int) m_deqR3.size();
  for ( int iR3Index = 0; iR3Index < iR3Size; iR3Index++ )
  {
    strTmp = " === R3 [" + String.format("%d", iR3Index + 1) + " of " + String.format("%d] ===\r\n", iR3Size);
    strMsg += strTmp;
  
    // 7.2 USER MESSAGE FORMAT CODES
    if ( m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes != -1 )
    {
      strTmp = "  User Message Format Codes: " + m_deqR3.get(iR3Index).m_sR3UserMessageFormatCodes + "\r\n";
      strMsg += strTmp;
    }
    
    // [FPI] 7.3.1 MESSAGE STANDARD VERSION
    if ( m_deqR3.get(iR3Index).m_sR3MessageStandardVersion != -1 )
    {
      strTmp = "  Message Standard Version: " + m_deqR3.get(iR3Index).m_sR3MessageStandardVersion + "\r\n";
      strMsg += strTmp;
    }
    
    if ( IsG4GroupPresent( iR3Index ) )
    {
      strMsg += "  - MESSAGE IDENTIFICATION GROUP - G4 -\r\n";
    
      // 7.4.1 FUNCTIONAL AREA DESIGNATOR
      if ( m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator != -1 )
      {
        strTmp = "    Functional Area Designator: " + m_deqR3.get(iR3Index).m_sR3G4FunctionalAreaDesignator + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.4.2 MESSAGE NUMBER
      if ( m_deqR3.get(iR3Index).m_sR3G4MessageNumber != -1 )
      {
        strTmp = "    Message Number: " + m_deqR3.get(iR3Index).m_sR3G4MessageNumber + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.4.3.1 MESSAGE SUBTYPE
      if ( m_deqR3.get(iR3Index).m_sR3G4MessageSubtype != -1 )
      {
        strTmp = "    Message Subtype: " + m_deqR3.get(iR3Index).m_sR3G4MessageSubtype + "\r\n";
        strMsg += strTmp;
      }
      
    } //END G4
    
    // [FPI] 7.5.1 FILE NAME
    if ( m_deqR3.get(iR3Index).m_strR3FileName != "" )
    {
      strTmp = "  File Name: " + m_deqR3.get(iR3Index).m_strR3FileName + "\r\n";
      strMsg += strTmp;
    }
    
    // [FPI] 7.6.1 MESSAGE SIZE
    if ( m_deqR3.get(iR3Index).m_iR3MessageSize != -1 )
    {
      strTmp = "  Message Size: " + m_deqR3.get(iR3Index).m_iR3MessageSize + "\r\n";
      strMsg += strTmp;
    }
    
    // 7.7 OPERATION INDICATOR
    if ( m_deqR3.get(iR3Index).m_sR3OperationIndicator != -1 )
    {
      strTmp = "  Operation Indicator: " + m_deqR3.get(iR3Index).m_sR3OperationIndicator + "\r\n";
      strMsg += strTmp;
    }
    
    // 7.8 RETRANSMIT INDICATOR
    if ( m_deqR3.get(iR3Index).m_sR3RetransmitIndicator != -1 )
    {
      strTmp = "  Retransmit Indicator: " + m_deqR3.get(iR3Index).m_sR3RetransmitIndicator + "\r\n";
      strMsg += strTmp;
    }
    
    // 7.9 MESSAGE PRECEDENCE CODE
    if ( m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode != -1 )
    {
      strTmp = "  Message Precedence Code: " + m_deqR3.get(iR3Index).m_sR3MessagePrecedenceCode + "\r\n";
      strMsg += strTmp;
    }
    
    // 7.10 SECURITY CLASSIFICATION
    if ( m_deqR3.get(iR3Index).m_sR3SecurityClassification != -1 )
    {
      strTmp = "  Security Classification: " + m_deqR3.get(iR3Index).m_sR3SecurityClassification + "\r\n";
      strMsg += strTmp;
    }
    
    // [FPI] 7.11.1 CONTROL/RELEASE MARKING
    if ( m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking != "" )
    {
      strTmp = "  Control Release Marking: " + m_deqR3.get(iR3Index).m_strR3ControlReleaseMarking + "\r\n";
      strMsg += strTmp;
    }
    
    if ( IsG5GroupPresent( iR3Index ) )
    {
      strMsg += "  - ORIGINATOR DATE TIME GROUP - G5 -\r\n";
    
      // 7.12.1 YEAR
      if ( m_deqR3.get(iR3Index).m_sR3G5Year != -1 )
      {
        strTmp = "    Year: " + m_deqR3.get(iR3Index).m_sR3G5Year + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.12.2 MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G5Month != -1 )
      {
        strTmp = "    Month: " + m_deqR3.get(iR3Index).m_sR3G5Month + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.12.3 DAY OF MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G5DayOfMonth != -1 )
      {
        strTmp = "    Day: " + m_deqR3.get(iR3Index).m_sR3G5DayOfMonth + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.12.4 HOUR
      if ( m_deqR3.get(iR3Index).m_sR3G5Hour != -1 )
      {
        strTmp = "    Hour: " + m_deqR3.get(iR3Index).m_sR3G5Hour + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.12.5 MINUTE
      if ( m_deqR3.get(iR3Index).m_sR3G5Minute != -1 )
      {
        strTmp = "    Minute: " + m_deqR3.get(iR3Index).m_sR3G5Minute + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.12.6 SECOND
      if ( m_deqR3.get(iR3Index).m_sR3G5Second != -1 )
      {
        strTmp = "    Second: " + m_deqR3.get(iR3Index).m_sR3G5Second + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.12.7.1 DTG EXTENSION
      if ( m_deqR3.get(iR3Index).m_sR3G5DtgExtension != -1 )
      {
        strTmp = "    Dtg Extension: " + m_deqR3.get(iR3Index).m_sR3G5DtgExtension + "\r\n";
        strMsg += strTmp;
      }
      
    } //END G5
    
    if ( IsG6GroupPresent( iR3Index ) )
    {
      strMsg += "  - PERISHABILITY DATE TIME GROUP - G6 -\r\n";
    
      // 7.13.1 YEAR
      if ( m_deqR3.get(iR3Index).m_sR3G6Year != -1 )
      {
        strTmp = "    Year: " + m_deqR3.get(iR3Index).m_sR3G6Year + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.13.2 MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G6Month != -1 )
      {
        strTmp = "    Month: " + m_deqR3.get(iR3Index).m_sR3G6Month + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.13.3 DAY OF MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G6DayOfMonth != -1 )
      {
        strTmp = "    Day: " + m_deqR3.get(iR3Index).m_sR3G6DayOfMonth + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.13.4 HOUR
      if ( m_deqR3.get(iR3Index).m_sR3G6Hour != -1 )
      {
        strTmp = "    Hour: " + m_deqR3.get(iR3Index).m_sR3G6Hour + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.13.5 MINUTE
      if ( m_deqR3.get(iR3Index).m_sR3G6Minute != -1 )
      {
        strTmp = "    Minute: " + m_deqR3.get(iR3Index).m_sR3G6Minute + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.13.6 SECOND
      if ( m_deqR3.get(iR3Index).m_sR3G6Second != -1 )
      {
        strTmp = "    Second: " + m_deqR3.get(iR3Index).m_sR3G6Second + "\r\n";
        strMsg += strTmp;
      }
      
    } //END G6
    
    if ( IsG7GroupPresent( iR3Index ) )
    {
      strMsg += "  - ACKNOWLEDGEMENT REQUEST GROUP - G7 -\r\n";
    
      // 7.14.1 MACHINE ACKNOWLEDGE REQUEST
      if ( m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest != -1 )
      {
        strTmp = "    Machine Acknowledge Request: " + m_deqR3.get(iR3Index).m_sR3G7MachineAcknowledgeRequest + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.14.2 OPERATOR ACKNOWLEDGE REQUEST
      if ( m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest != -1 )
      {
        strTmp = "    Operator Acknowledge Request: " + m_deqR3.get(iR3Index).m_sR3G7OperatorAcknowledgeRequest + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.14.3 OPERATOR REPLY REQUEST
      if ( m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest != -1 )
      {
        strTmp = "    Operator Reply Request: " + m_deqR3.get(iR3Index).m_sR3G7OperatorReplyRequest + "\r\n";
        strMsg += strTmp;
      }
      
    } //END G7
    
    if ( IsG8GroupPresent( iR3Index ) )
    {
      strMsg += "  - DTG OF MESSAGE BEING ACKNOWLEDGED - G8 -\r\n";
    
      // 7.15.1 YEAR
      if ( m_deqR3.get(iR3Index).m_sR3G8Year != -1 )
      {
        strTmp = "    Year: " + m_deqR3.get(iR3Index).m_sR3G8Year + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.2 MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G8Month != -1 )
      {
        strTmp = "    Month: " + m_deqR3.get(iR3Index).m_sR3G8Month + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.3 DAY OF MONTH
      if ( m_deqR3.get(iR3Index).m_sR3G8DayOfMonth != -1 )
      {
        strTmp = "    Day: " + m_deqR3.get(iR3Index).m_sR3G8DayOfMonth + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.4 HOUR
      if ( m_deqR3.get(iR3Index).m_sR3G8Hour != -1 )
      {
        strTmp = "    Hour: " + m_deqR3.get(iR3Index).m_sR3G8Hour + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.5 MINUTE
      if ( m_deqR3.get(iR3Index).m_sR3G8Minute != -1 )
      {
        strTmp = "    Minute: " + m_deqR3.get(iR3Index).m_sR3G8Minute + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.6 SECOND
      if ( m_deqR3.get(iR3Index).m_sR3G8Second != -1 )
      {
        strTmp = "    Second: " + m_deqR3.get(iR3Index).m_sR3G8Second + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.15.7.1 DTG EXTENSION
      if ( m_deqR3.get(iR3Index).m_sR3G8DtgExtension != -1 )
      {
        strTmp = "    Dtg Extension: " + m_deqR3.get(iR3Index).m_sR3G8DtgExtension + "\r\n";
        strMsg += strTmp;
      }
      
      // 7.15.8 RECEIPT/COMPLIANCE (R/C)
      if ( m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC != -1 )
      {
        strTmp = "    Receipt Compliance R C: " + m_deqR3.get(iR3Index).m_sR3G8ReceiptComplianceRC + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.15.9.1 CANTCO REASON CODE
      if ( m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode != -1 )
      {
        strTmp = "    Cantco Reason Code: " + m_deqR3.get(iR3Index).m_sR3G8CantcoReasonCode + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.15.10.1 CANTPRO REASON CODE
      if ( m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode != -1 )
      {
        strTmp = "    Cantpro Reason Code: " + m_deqR3.get(iR3Index).m_sR3G8CantproReasonCode + "\r\n";
        strMsg += strTmp;
      }
      
      // [FPI] 7.15.11.1 REPLY AMPLIFICATION
      if ( m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification != "" )
      {
        strTmp = "    Reply Amplification: " + m_deqR3.get(iR3Index).m_strR3G8ReplyAmplification + "\r\n";
        strMsg += strTmp;
      }
      
    } //END G8
    
    if ( IsG9GroupPresent( iR3Index ) )
    {
      strMsg += "  - REFERENCE MESSAGE DATA GROUP - G9 -\r\n";
    
      // R3R4
      int iR4Size = (int) m_deqR3.get(iR3Index).m_deqR4.size();
      for ( int iR4Index = 0; iR4Index < iR4Size; iR4Index++ )
      {
        strTmp = "     === R4 [" + String.format("%d", iR4Index + 1) + " of " + String.format("%d] ===\r\n", iR4Size);
        strMsg += strTmp;
      
        // [FPI] 7.16.1.2.1 URN
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn != -1 )
        {
          strTmp = "      Urn: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_iR3G9R4Urn + "\r\n";
          strMsg += strTmp;
        }
        
        // [FPI] 7.16.1.3.1 UNIT LONG NAME
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName != "" )
        {
          strTmp = "      Unit Long Name: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_strR3G9R4UnitLongName + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.4 YEAR
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year != -1 )
        {
          strTmp = "      Year: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Year + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.5 MONTH
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month != -1 )
        {
          strTmp = "      Month: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Month + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.6 DAY OF MONTH
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth != -1 )
        {
          strTmp = "      Day: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DayOfMonth + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.7 HOUR
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour != -1 )
        {
          strTmp = "      Hour: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Hour + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.8 MINUTE
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute != -1 )
        {
          strTmp = "      Minute: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Minute + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.16.1.9 SECOND
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second != -1 )
        {
          strTmp = "      Second: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4Second + "\r\n";
          strMsg += strTmp;
        }
        
        // [FPI] 7.16.1.10.1 DTG EXTENSION
        if ( m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension != -1 )
        {
          strTmp = "      Dtg Extension: " + m_deqR3.get(iR3Index).m_deqR4.get(iR4Index).m_sR3G9R4DtgExtension + "\r\n";
          strMsg += strTmp;
        }
        
      } //END R4
      
    } //END G9
    
    if ( IsG10GroupPresent( iR3Index ) )
    {
      strMsg += "  - MESSAGE SECURITY GROUP - G10 -\r\n";
    
      // 7.17.1 SECURITY PARAMETERS INFORMATION (SPI)
      if ( m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi != -1 )
      {
        strTmp = "    Security Parameters Information Spi: " + m_deqR3.get(iR3Index).m_sR3G10SecurityParametersInformationSpi + "\r\n";
        strMsg += strTmp;
      }
      
      if ( IsG11GroupPresent( iR3Index ) )
      {
        strMsg += "    - KEYING MATERIAL GROUP - G11 -\r\n";
      
        // 7.17.2.1 KEYING MATERIAL ID LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength != -1 )
        {
          strTmp = "      Keying Material Id Length: " + m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialIdLength + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.17.2.2 KEYING MATERIAL ID
        if ( m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId != 0 )
        {
          strTmp = "      Keying Material Id: " + m_deqR3.get(iR3Index).m_sR3G10G11KeyingMaterialId + "\r\n";
          strMsg += strTmp;
        }
        
      } //END G11
      
      if ( IsG12GroupPresent( iR3Index ) )
      {
        strMsg += "    - CRYPTOGRAPHIC INITIALIZATION GROUP - G12 -\r\n";
      
        // 7.17.3.1 CRYPTOGRAPHIC INITIALIZATION LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength != -1 )
        {
          strTmp = "      Cryptographic Initialization Length: " + m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitializationLength + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.17.3.2 CRYPTOGRAPHIC INITIALIZATION
        if ( m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization != 0 )
        {
          strTmp = "      Cryptographic Initialization: " + m_deqR3.get(iR3Index).m_sR3G10G12CryptographicInitialization + "\r\n";
          strMsg += strTmp;
        }
        
      } //END G12
      
      if ( IsG13GroupPresent( iR3Index ) )
      {
        strMsg += "    - KEY TOKEN GROUP - G13 -\r\n";
      
        // 7.17.4.1 KEY TOKEN LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength != -1 )
        {
          strTmp = "      Key Token Length: " + m_deqR3.get(iR3Index).m_sR3G10G13KeyTokenLength + "\r\n";
          strMsg += strTmp;
        }
        
        // R3R5
        int iR5Size = (int) m_deqR3.get(iR3Index).m_deqR5.size();
        for ( int iR5Index = 0; iR5Index < iR5Size; iR5Index++ )
        {
          strTmp = "       === R5 [" + String.format("%d", iR5Index + 1) + " of " + String.format("%d] ===\r\n", iR5Size);
          strMsg += strTmp;
        
          // 7.17.4.2.2 KEY TOKEN
          if ( m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken != 0 )
          {
            strTmp = "        Key Token: " + m_deqR3.get(iR3Index).m_deqR5.get(iR5Index).m_sR3G10G13R5KeyToken + "\r\n";
            strMsg += strTmp;
          }
          
        } //END R5
        
      } //END G13
      
      if ( IsG14GroupPresent( iR3Index ) )
      {
        strMsg += "    - AUTHENTICATION (A) GROUP - G14 -\r\n";
      
        // 7.17.5.1 AUTHENTICATION DATA (A) LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength != -1 )
        {
          strTmp = "      Authentication Data A Length: " + m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataALength + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.17.5.2 AUTHENTICATION DATA (A)
        if ( m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA != 0 )
        {
          strTmp = "      Authentication Data A: " + m_deqR3.get(iR3Index).m_sR3G10G14AuthenticationDataA + "\r\n";
          strMsg += strTmp;
        }
        
      } //END G14
      
      if ( IsG15GroupPresent( iR3Index ) )
      {
        strMsg += "    - AUTHENTICATION (B) GROUP - G15 -\r\n";
      
        // 7.17.6.1 AUTHENTICATION DATA (B) LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength != -1 )
        {
          strTmp = "      Authentication Data B Length: " + m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataBLength + "\r\n";
          strMsg += strTmp;
        }
        
        // 7.17.6.2 AUTHENTICATION DATA (B)
        if ( m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB != 0 )
        {
          strTmp = "      Authentication Data B: " + m_deqR3.get(iR3Index).m_sR3G10G15AuthenticationDataB + "\r\n";
          strMsg += strTmp;
        }
        
      } //END G15
      
      // 7.17.7 SIGNED ACKNOWLEDGE REQUEST INDICATOR
      if ( m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator != -1 )
      {
        strTmp = "    Signed Acknowledge Request Indicator: " + m_deqR3.get(iR3Index).m_sR3G10SignedAcknowledgeRequestIndicator + "\r\n";
        strMsg += strTmp;
      }
      
      if ( IsG16GroupPresent( iR3Index ) )
      {
        strMsg += "    - MESSAGE SECURITY PADDING GROUP - G16 -\r\n";
      
        // 7.17.8.1 MESSAGE SECURITY PADDING LENGTH
        if ( m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength != -1 )
        {
          strTmp = "      Message Security Padding Length: " + m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPaddingLength + "\r\n";
          strMsg += strTmp;
        }
        
        // [FPI] 7.17.8.2.1 MESSAGE SECURITY PADDING
        if ( m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding != 0 )
        {
          strTmp = "      Message Security Padding: " + m_deqR3.get(iR3Index).m_sR3G10G16MessageSecurityPadding + "\r\n";
          strMsg += strTmp;
        }
        
      } //END G16
      
    } //END G10
    
  } //END R3
  
  return strMsg;
}


// Extract Message 

public int ExtractMessage( byte[] pBuffer, int iLengthInBytes, int iR3Index, byte[] pOut, int[] iMsgLength) 
{
  int iError = ERROR_MSG_HDC_6017_NO_ERROR;
  if( iR3Index <= m_deqR3.size())
  {
    iMsgLength[0] = 0;
    // get data following header
    int iHeaderLength = m_iDecodeBitOffset / 8;
    int iBitOffset = m_iDecodeBitOffset % 8;
    // header must end on a byte boundary
    if ( iBitOffset != 0 )
    {
      iHeaderLength += 1;
    }
    // create data block to store message data
    int iSizeOfAllMessages = 0;
    iSizeOfAllMessages = iLengthInBytes - iHeaderLength;
    int iOffsetToMsgData = iHeaderLength;
    for ( int cMsg = 0; cMsg < (int) m_deqR3.size() && iOffsetToMsgData < iLengthInBytes; cMsg++ )
    {
      if ( GetR3MessageSize( cMsg ) > iSizeOfAllMessages ) 
      { 
        PutR3MessageSize( cMsg, iSizeOfAllMessages );
      } 
      else if ( GetR3MessageSize( cMsg ) == -1 )
      { 
        PutR3MessageSize( cMsg, iSizeOfAllMessages );
      } 
   }
   if ( m_sDataCompressionType != -1 )
   { 
    try { 
      int  msgSize = GetR3MessageSize( iR3Index ); 
      byte b4 = pBuffer[iLengthInBytes-4]; 
      byte b3 = pBuffer[iLengthInBytes-3]; 
      byte b2 = pBuffer[iLengthInBytes-2]; 
      byte b1 = pBuffer[iLengthInBytes-1]; 
      long unzippedSize = ((long)(0xFF & b1) << 24 | (long)(0xFF & b2) << 16 | (long)(0xFF & b3) << 8 | (long)(0xFF & b4)); 
      if( unzippedSize > 0 ) { 
        byte[] zipedByteArray = new byte[msgSize]; 
        System.arraycopy( pBuffer, iOffsetToMsgData, zipedByteArray, 0, msgSize ); 
        ByteArrayInputStream inStream = new ByteArrayInputStream( zipedByteArray ); 
        GZIPInputStream zInput = new GZIPInputStream( inStream ); 
        int count = 0; 
        if( unzippedSize > 1024) { 
          byte[] buff = new byte[1024]; 
          int index = 0; 
          while((count = zInput.read( buff, 0, 1024))!= -1) { 
            System.arraycopy( buff, 0, pOut, index, count ); 
            index = index + count; 
          } 
        } else { 
          zInput.read( pOut, 0, (int)unzippedSize ); 
        } 
        zInput.close(); 
        inStream.close(); 
        iMsgLength[0] = (int)unzippedSize; 
      } 
      else { 
        iMsgLength[0] = 0; 
        iError = ERROR_MSG_HDC_6017_DECODE_DATA_COMPRESSION_TYPE; 
      } 
    } catch ( IOException e ) { 
      // e.printStackTrace(); 
      iError = ERROR_MSG_HDC_6017_DECODE_DATA_COMPRESSION_TYPE; 
    } 
  } 
  else 
    { 
      iMsgLength[0] = GetR3MessageSize( iR3Index ); 
      if ( iMsgLength[0] > 0 ) 
      { 
        System.arraycopy( pBuffer, iHeaderLength, pOut, 0, iMsgLength[0]);
      } 
      else 
      { 
        iError = ERROR_MSG_HDC_6017_DECODE_ZERO_BYTES; 
	    } 
    } 
  } 
  else 
  { 
    iError = ERROR_MSG_HDC_6017_DECODE_ZERO_BYTES; 
  } 
  return iError; 
 } 



};

