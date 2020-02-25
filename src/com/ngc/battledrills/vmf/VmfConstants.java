//package vmfjavatest.vmfparser;
package com.ngc.battledrills.vmf;

public class VmfConstants {

	/* Copyright Northrop Grumman Corporation (2008)
	   All Rights Reserved.
	   This material may be reproduced by or for the U.S. Government pursuant to
	   the copyright license under the clause at Defense Federal Acquisition Regulation
	   Supplement (DFARS)=252.227-7014 (June=1995 ).
	*/

	// VmfConstants.h: constants used in VMF messages
	//
	//////////////////////////////////////////////////////////////////////

	// VMF Message Types
	public static final int VMF_MSG                     =100;
	public static final int VMF_K00_3                   =003;
	public static final int VMF_K00_5                   =005;
	public static final int VMF_K01_1                   =101;
	public static final int VMF_K01_2                   =102;
	public static final int VMF_K02_1                   =201;
	public static final int VMF_K02_4                   =204;
	public static final int VMF_K02_6                   =206;
	public static final int VMF_K02_9                   =209;
	public static final int VMF_K02_14                  =214;
	public static final int VMF_K02_16                  =216;
	public static final int VMF_K02_22                  =222;
	public static final int VMF_K02_25                  =225;
	public static final int VMF_K02_27                  =227;
	public static final int VMF_K02_28                  =228;
	public static final int VMF_K02_31                  =231;
	public static final int VMF_K02_32                  =232;
	public static final int VMF_K04_1                   =401;
	public static final int VMF_K04_2                   =402;
	public static final int VMF_K05_1                   =501;
	public static final int VMF_K05_2                   =502;
	public static final int VMF_K05_11                  =511;
	public static final int VMF_K05_13                  =513;
	public static final int VMF_K05_14                  =514;
	public static final int VMF_K05_17                  =517;
	public static final int VMF_K05_19                  =519;
	public static final int VMF_K07_1                   =701;
	public static final int VMF_K07_2                   =702;
	public static final int VMF_K07_3                   =703;
	public static final int VMF_K07_10                  =710;
	public static final int VMF_K07_11                  =711;

	public static final int MAX_UNIT_NAME_LENGTH        =64;

	// Header Version
	public static final int VERSION_MIL_47001              =0;
	public static final int VERSION_MIL_47001B             =1;
	public static final int VERSION_MIL_47001C             =2;
	public static final int VERSION_MIL_47001D             =3;
	public static final int VERSION_MIL_47001D1            =4;        
	public static final int VERSION_UNDEFINED              =5;
	public static final int VERSION_NOT_IMPLEMENTED        =15;

	// Data Compression Type
	public static final int LZW_UNIX_COMPRESSION           =0;
	public static final int LZ77_COMPRESSION               =1;

	// User Message Format Code
	public static final int UMF_TADIL_J                    =0;
	public static final int UMF_BINARY_FILE                =1;
	public static final int UMF_VMF                        =2;
	public static final int UMF_NITF                       =3;
	public static final int UMF_FORWARDED_MESSAGE          =4;
	public static final int UMF_USMTF                      =5;
	public static final int UMF_DOI_103                    =6;
	public static final int UMF_UNKNOWN                    =7;

	// Operation Indicator Codes (OIC)
	public static final int OIC_OPERATION                   =0;
	public static final int OIC_EXERCISE                    =1;
	public static final int OIC_SIMULATION                  =2;
	public static final int OIC_TEST                        =3;	

	// Retransmit Indicator
	public static final int RETRANSMIT_NOT_REQUIRED         =0;
	public static final int RETRANSMIT_REQUIRED             =1;

	// Message Precedence Code (MPC)
	public static final int MPC_UNDEFINED0                  =0;
	public static final int MPC_UNDEFINED1                  =1;
	public static final int MPC_EMERGENCY_COMMAND           =2;
	public static final int MPC_NOT_USED                    =3;
	public static final int MPC_FLASH                       =4;
	public static final int MPC_IMMEDIATE                   =5;
	public static final int MPC_PRIORITY                    =6;
	public static final int MPC_ROUTINE                     =7;
	
	// Message Precedence Codes for D and D1
    // Added by Randy Eastwood
    public static final int MPD_D1_ROUTINE                  =0;
    public static final int MPD_D1_PRIORITY                 =1;
    public static final int MPD_D1_IMMEDIATE                =2;
    public static final int MPD_D1_FLASH                    =3;
    public static final int MPD_D1_FLASH_OVERRIDE           =4;
    public static final int MPD_D1_CRITIC_ECP               =5;
    public static final int MPD_D1_RESERVED6                =6;
    public static final int MPD_D1_RESERVED7                =7;
	

	// MIL-2045-47001C VMF Reissue values
	public static final int TIDP_TE_R2                      =0;
	public static final int TIDP_TE_R3                      =1;
	public static final int TIDP_TE_R4                      =2;
	public static final int TIDP_TE_R5                      =3;
	public static final int TIDP_TE_R6                      =4;
	public static final int TIDP_TE_R7                      =5;
	public static final int VMF_REISSUE_6017                =6;
	public static final int VMF_REISSUE_6017A               =7;
	public static final int VMF_REISSUE_6017B               =8;
	public static final int VMF_REISSUE_6017C               =9;
        // MIL-2045-47001D Change 1 VMF Reissue values
 	public static final int HD1_TIDP_TE_R3                      =1;
	public static final int HD1_TIDP_TE_R4                      =2;
	public static final int HD1_TIDP_TE_R5                      =3;
	public static final int HD1_TIDP_TE_R6                      =4;
	public static final int HD1_VMF_REISSUE_6017                =5;
	public static final int HD1_VMF_REISSUE_6017A               =6;
	public static final int HD1_VMF_REISSUE_6017B               =7;
	public static final int HD1_VMF_REISSUE_6017C               =8;
        public static final int HD1_VMF_REISSUE_6017D               =9;
       	public static final int HD1_VMF_REISSUE_6017E               =10;    
        
	public static final int NUM_VMF_REISSUES_IN_USE         =3; //TIDP_TE_R5,VMF_REISSUE_6017,VMF_REISSUE_6017A
	public static final String MULTIPLE_VMF_FILES_IN_USE    ="MULTIPLEVMFFILELIST";  //_T("MULTIPLEVMFFILELIST")

	// Functional Area Designator (FAD)
	public static final int FAD_NETWORK_CONTROL             =0;
	public static final int FAD_SYSTEM_INFORMATION_EXCHANGE =1;
	public static final int FAD_FIRE_SUPPORT                =2;
	public static final int FAD_AIR_OPERATIONS              =3;
	public static final int FAD_INTELLIGENCE_OPERATIONS     =4;
	public static final int FAD_LAND_COMBAT_OPERATIONS      =5;
	public static final int FAD_MARITIME_OPERATIONS         =6;
	public static final int FAD_COMBAT_SERVICE_SUPPORT      =7;
	public static final int FAD_SPECIAL_OPERATIONS          =8;
	public static final int FAD_JTF_OPERATIONS_CONTROL      =9;
	public static final int FAD_AIR_DEFENSE_SPACE_CTRL      =10;
	public static final int FAD_NOT_DEFINED                 =11;

	// Security Classification (SC)
	public static final int SC_UNCLASSIFIED                 =0;
	public static final int SC_CONFIDENTIAL                 =1;
	public static final int SC_SECRET                       =2;
	public static final int SC_TOP_SECRET                   =3;

	// Machine Acknowledge (MACK) Indicator
	public static final int MACK_NOT_REQUIRED               =0;
	public static final int MACK_REQUIRED                   =1;

	// Operator Acknowledge Indicator
	public static final int OPRACK_NOT_REQUIRED             =0;
	public static final int OPRACK_REQUIRED                 =1;

	// Operator Reply Request Indicator
	public static final int OPREPLY_NOT_REQUIRED            =0;
	public static final int OPREPLY_REQUIRED                =1;

	// Receipt/Compliance Code (RC)
	public static final int RC_UNDEFINED                    =0;
	public static final int RC_MACHINE_RECEIPT              =1;
	public static final int RC_CANTPRO                      =2;
	public static final int RC_OPRACK                       =3;
	public static final int RC_WILCO                        =4;
	public static final int RC_HAVCO                        =5;
	public static final int RC_CANTCO                       =6;

	// CANTPRO Reason Code
	public static final int CANTPRO_UNDEFINED               =0;
	public static final int CANTPRO_FIELD_CONTENT           =1;
	public static final int CANTPRO_MESSAGE_INCORRECT_ROUTE =2;
	public static final int CANTPRO_ADDRESS_INACTIVE        =3;
	public static final int CANTPRO_REFERENCE_POINT_UNKNOWN =4;        
	public static final int CANTPRO_FIRE_UNIT_CONTROL       =5;
	public static final int CANTPRO_MISSION_CONTROL         =6;
	public static final int CANTPRO_MISSION_NUMBER_UNKNOWN  =7;
	public static final int CANTPRO_TARGET_NUMBER_UNKNOWN   =8;
	public static final int CANTPRO_SCHEDULE_NUMBER_UNKNOWN =9;
	public static final int CANTPRO_CONTROL_ADDRESS         =10;
	public static final int CANTPRO_TRACK_NUMBER            =11;
	public static final int CANTPRO_INVALID_GIVEN_FIELD     =12;            
	public static final int CANTPRO_MESSAGE_CONVERSION      =13;
	public static final int CANTPRO_AGENCY_FILE_FULL        =14;
	public static final int CANTPRO_AGENCY_RECOGNITION      =15;
	public static final int CANTPRO_AGENCY_CORRELATE        =16;
	public static final int CANTPRO_AGENCY_LIMIT            =17;
	public static final int CANTPRO_AGENCY_COMPUTER         =18;
	public static final int CANTPRO_ADDRESSEE_UNKNOWN       =19;
	public static final int CANTPRO_CANT_FORWARD_AGENCY     =20;
	public static final int CANTPRO_CANT_FORWARD_LINK       =21;
	public static final int CANTPRO_ILLOGICAL_JUXTAPOSITION =22;
	public static final int CANTPRO_UNCOMPRESS_UNIX         =23;
	public static final int CANTPRO_UNCOMPRESS_LZ_77        =24;
	public static final int CANTPRO_MESSAGE_TOO_OLD         =25;
	public static final int CANTPRO_SECURITY_RESTRICTION    =26;
	public static final int CANTPRO_AUTHENTICATION_FAILURE  =27;
	public static final int CANTPRO_CERTIFICATE_NOT_FOUND   =28;
	public static final int CANTPRO_CERTIFICATE_INVALID     =29;
	public static final int CANTPRO_DO_NOT_SUPPROT_SPI_VA   =30;
	public static final int CANTPRO_CANNOT_GENERATE_SACK    =31;

	// CANTCO Reason Code
	public static final int CANTCO_COMMUNICATIONS           =0;
	public static final int CANTCO_AMMUNITION               =1;
	public static final int CANTCO_PERSONNEL                =2;
	public static final int CANTCO_FEUL                     =3;
	public static final int CANTCO_TERRAIN_ENVIRONMENT      =4;
	public static final int CANTCO_EQUIPMENT                =5;
	public static final int CANTCO_TACTICAL_SITUATION       =6;
	public static final int CANTCO_OTHER                    =7;

	// Signed Acknowledge Request Indicator
	public static final int SACK_NOT_REQUIRED               =0;
	public static final int SACK_REQUIRED                   =1;

	// Security Events
	public static final int SE_UNKNOWN                            =0;
	public static final int SE_CHANGE_OF_USER_SENSITIVITY         =1;
	public static final int SE_LOCAL_DISABLE_INITIATED            =2;
	public static final int SE_UNAUTHORIZED_SENSITIVITY_LEVEL     =3;
	public static final int SE_PASSWORD_EXPIRATION_WARNING_ELAPSED=4;
	public static final int SE_LOGON_ATTEMPTS_EXCEEDED            =5;
	public static final int SE_REAUTHENTICATION_REQUEST           =6;
	public static final int SE_REAUTHENTICATION_REQUEST_WLOCKOUT  =7;
	public static final int SE_LOCKOUT_INITIATED                  =8;
	public static final int SE_REAUTHENTICATION_TIMEOUT           =9;
	public static final int SE_SUCCESSFUL_REAUTHENTICATION        =10;
	public static final int SE_REMOTE_DISABLE_COMMAND             =11;
	public static final int SE_REMOTE_DISABLE_INITIATED           =12;
	public static final int SE_PASSWORDS_MODIFIED                 =13;
	public static final int SE_MESSAGE_AUTHENTICATION_FAILURE     =14;
	public static final int SE_SYSTEM_INTRUSION_DETECTED          =15;
	public static final int SE_PUBLIC_KEY_CERT_EXPIRED            =16;

	// service
	public static final int SVC_AIR_FORCE=0;
	public static final int SVC_ARMY     =1;
	public static final int SVC_NAVY     =2;
	public static final int SVC_MARINE   =3;
	public static final int SVC_UNKNOWN  =4;
	public static final int SVC_NOT_SET  =-1;
;
	// size
	public static final int ECH_TEAM                        =0;
	public static final int ECH_SQUAD                       =1;
	public static final int ECH_SECTION                     =2;
	public static final int ECH_PLATOON                     =3;
	public static final int ECH_COMPANY_BATTERY             =4;
	public static final int ECH_BATTALION                   =5;
	public static final int ECH_REGIMENT                    =6;
	public static final int ECH_BRIGADE                     =7;
	public static final int ECH_DIVISION                    =8;
	public static final int ECH_CORP                        =9;
	public static final int ECH_ARMY                       =10;
	public static final int ECH_ARMY_GROUP_FRONT           =11;
	public static final int ECH_REGION                     =12;
	public static final int ECH_UNKNOWN                    =13;
	public static final int ECH_NOT_SET                    =-1;

	// track type
	public static final int	TYPE_ACOUSTIC   =0;  
	public static final int	TYPE_EMITTER    =1; 
	public static final int	TYPE_GENERIC    =2;  
	public static final int	TYPE_LINK       =3;  
	public static final int	TYPE_PLATFORM   =4;  
	public static final int	TYPE_PLRS       =5;  
	public static final int	TYPE_UNIT       =6;  
	public static final int	TYPE_PLI        =7;  
	public static final int	TYPE_UNKNOWN    =8;  
	public static final int	TYPE_REPORT     =9;
	public static final int TYPE_NOT_SET    =-1;

	// Track Threat
	public static final int THREAT_PENDING                 =0;
	public static final int THREAT_UNKNOWN                 =1;
	public static final int THREAT_ASSUMED_FRIEND          =2;
	public static final int THREAT_FRIEND                  =3;
	public static final int THREAT_NEUTRAL                 =4;
	public static final int THREAT_SUSPECT                 =5;
	public static final int THREAT_HOSTILE                 =6;
	public static final int THREAT_EXERCISE_PENDING        =7;
	public static final int THREAT_EXERCISE_UNKNOWN        =8;
	public static final int THREAT_EXERCISE_ASSUMED_FRIEND =9;
	public static final int THREAT_EXERCISE_FRIEND         =10;
	public static final int THREAT_EXERCISE_NEUTRAL        =11;
	public static final int THREAT_JOKER                   =12;
	public static final int THREAT_FAKER                   =13;
	public static final int THREAT_NOT_SET                 =-1;

	// Track Status
	public static final int	STATUS_TRACK                     =0;
	public static final int	STATUS_OFFLINE_POSITION_CHANGE   =1;
	public static final int	STATUS_OFFLINE_ATTRIBUTE_CHANGE  =2;
	public static final int	STATUS_OFFLINE_ALL_CHANGE        =3;
	public static final int STATUS_VMF_OBSERVED_POSITION     =4;
	public static final int STATUS_VMF_OBSTACLE_REPORT       =5;
	public static final int STATUS_VMF_BRIDGE_REPORT         =6;
	public static final int STATUS_VMF_NBC1_REPORT           =7;
	public static final int STATUS_VMF_FIRE_MISSION_REPORT   =8;
	public static final int STATUS_VMF_STRIKE_WARNING        =9;
	public static final int STATUS_VMF_THREAT_WARNING        =10;
	public static final int STATUS_VMF_SUPPLY_POINT_REPORT   =11;
	public static final int STATUS_VMF_IED_REPORT            =12;
	public static final int STATUS_VMF_MEDEVAC_REPORT        =13;
	public static final int STATUS_RADIO_GENERATED_TRACK     =14;
	public static final int STATUS_NOT_SET                    =-1;

	// Error Codes
	public static final int HEADER_NO_ERROR                    =0;

	public static final int ERROR_MESSAGE_DECODE_ERROR         =1;

	public static final int ERROR_K00_03_NO_ERROR             =300;
	public static final int ERROR_K00_03_ENCODE_ERROR         =399;

	public static final int ERROR_K00_05_NO_ERROR             =500;
	public static final int ERROR_K00_05_DECODE_ERROR         =598;
	public static final int ERROR_K00_05_ENCODE_ERROR         =599;

	public static final int ERROR_K01_01_NO_ERROR             =10100;
	public static final int ERROR_K01_01_ENCODE_ERROR         =10199;

	public static final int ERROR_K01_02_NO_ERROR             =10200;
	public static final int ERROR_K01_02_DECODE_ERROR         =10298;
	public static final int ERROR_K01_02_ENCODE_ERROR         =10299;

	public static final int ERROR_K02_01_NO_ERROR             =20100;
	public static final int ERROR_K02_01_DECODE_ERROR         =20198;
	public static final int ERROR_K02_01_ENCODE_ERROR         =20199;

	public static final int ERROR_K02_04_NO_ERROR             =20400;
	public static final int ERROR_K02_04_DECODE_ERROR         =20498;
	public static final int ERROR_K02_04_ENCODE_ERROR         =20499;

	public static final int ERROR_K02_06_NO_ERROR             =20600;
	public static final int ERROR_K02_06_DECODE_ERROR         =20698;
	public static final int ERROR_K02_06_ENCODE_ERROR         =20699;

	public static final int ERROR_K02_09_NO_ERROR             =20900;
	public static final int ERROR_K02_09_DECODE_ERROR         =20998;
	public static final int ERROR_K02_09_ENCODE_ERROR         =20999;

	public static final int ERROR_K02_12_NO_ERROR             =21200;
	public static final int ERROR_K02_12_DECODE_ERROR         =21298;
	public static final int ERROR_K02_12_ENCODE_ERROR         =21299;

	public static final int ERROR_K02_13_NO_ERROR             =21300;
	public static final int ERROR_K02_13_DECODE_ERROR         =21398;
	public static final int ERROR_K02_13_ENCODE_ERROR         =21399;

	public static final int ERROR_K02_14_NO_ERROR             =21400;
	public static final int ERROR_K02_14_DECODE_ERROR         =21498;
	public static final int ERROR_K02_14_ENCODE_ERROR         =21499;

	public static final int ERROR_K02_16_NO_ERROR             =21600;
	public static final int ERROR_K02_16_DECODE_ERROR         =21698;
	public static final int ERROR_K02_16_ENCODE_ERROR         =21699;

	public static final int ERROR_K02_22_NO_ERROR             =22200;
	public static final int ERROR_K02_22_DECODE_ERROR         =22298;
	public static final int ERROR_K02_22_ENCODE_ERROR         =22299;

	public static final int ERROR_K02_25_NO_ERROR             =22500;
	public static final int ERROR_K02_25_DECODE_ERROR         =22598;
	public static final int ERROR_K02_25_ENCODE_ERROR         =22599;

	public static final int ERROR_K02_27_NO_ERROR             =22700;
	public static final int ERROR_K02_27_DECODE_ERROR         =22798;
	public static final int ERROR_K02_27_ENCODE_ERROR         =22799;

	public static final int ERROR_K02_28_NO_ERROR             =22800;
	public static final int ERROR_K02_28_DECODE_ERROR         =22898;
	public static final int ERROR_K02_28_ENCODE_ERROR         =22899;

	public static final int ERROR_K02_31_NO_ERROR             =23100;
	public static final int ERROR_K02_31_DECODE_ERROR         =23198;
	public static final int ERROR_K02_31_ENCODE_ERROR         =23199;

	public static final int ERROR_K02_32_NO_ERROR             =23200;
	public static final int ERROR_K02_32_DECODE_ERROR         =23298;
	public static final int ERROR_K02_32_ENCODE_ERROR         =23299;

	public static final int ERROR_K04_01_NO_ERROR             =40100;
	public static final int ERROR_K04_01_DECODE_ERROR         =40198;
	public static final int ERROR_K04_01_ENCODE_ERROR         =40199;

	public static final int ERROR_K04_02_NO_ERROR             =40200;
	public static final int ERROR_K04_02_DECODE_ERROR         =40298;
	public static final int ERROR_K04_02_ENCODE_ERROR         =40299;

	public static final int ERROR_K05_01_NO_ERROR             =50100;
	public static final int ERROR_K05_01_DECODE_ERROR         =50198;
	public static final int ERROR_K05_01_ENCODE_ERROR         =50199;

	public static final int ERROR_K05_02_NO_ERROR             =50200;
	public static final int ERROR_K05_02_DECODE_ERROR         =50298;
	public static final int ERROR_K05_02_ENCODE_ERROR         =50299;

	public static final int ERROR_K05_11_NO_ERROR             =51100;
	public static final int ERROR_K05_11_DECODE_ERROR         =51198;
	public static final int ERROR_K05_11_ENCODE_ERROR         =51199;

	public static final int ERROR_K05_13_NO_ERROR             =51300;
	public static final int ERROR_K05_13_DECODE_ERROR         =51398;
	public static final int ERROR_K05_13_ENCODE_ERROR         =51399;

	public static final int ERROR_K05_14_NO_ERROR             =51400;
	public static final int ERROR_K05_14_DECODE_ERROR         =51498;
	public static final int ERROR_K05_14_ENCODE_ERROR         =51499;

	public static final int ERROR_K05_17_NO_ERROR             =51700;
	public static final int ERROR_K05_17_DECODE_ERROR         =51798;
	public static final int ERROR_K05_17_ENCODE_ERROR         =51799;

	public static final int ERROR_K05_19_NO_ERROR             =51900;
	public static final int ERROR_K05_19_DECODE_ERROR         =51998;
	public static final int ERROR_K05_19_ENCODE_ERROR         =51999;

	public static final int ERROR_K07_01_NO_ERROR             =70100;
	public static final int ERROR_K07_01_DECODE_ERROR         =70198;
	public static final int ERROR_K07_01_ENCODE_ERROR         =70199;

	public static final int ERROR_K07_02_NO_ERROR             =70200;
	public static final int ERROR_K07_02_DECODE_ERROR         =70298;
	public static final int ERROR_K07_02_ENCODE_ERROR         =70299;

	public static final int ERROR_K07_03_NO_ERROR             =70300;
	public static final int ERROR_K07_03_DECODE_ERROR         =70398;
	public static final int ERROR_K07_03_ENCODE_ERROR         =70399;

	public static final int ERROR_K07_10_NO_ERROR             =71000;
	public static final int ERROR_K07_10_DECODE_ERROR         =71098;
	public static final int ERROR_K07_10_ENCODE_ERROR         =71099;

	public static final int ERROR_K07_11_NO_ERROR             =71100;
	public static final int ERROR_K07_11_DECODE_ERROR         =71198;
	public static final int ERROR_K07_11_ENCODE_ERROR         =71199;

	public static final int ERROR_K02_33_NO_ERROR             =23300;
	public static final int ERROR_K02_33_DECODE_ERROR         =23398;
	public static final int ERROR_K02_33_ENCODE_ERROR         =23399;

	// VMF Message Number
	public static final int VMF_K04_01                             =0401;
	public static final int VMF_K05_01                             =0501;

	// NOT SET Values
	public static final int LATITUDE_NOT_SET                        =-9999;
	public static final int LONGITUDE_NOT_SET                       =-9999;
	public static final int ELEVATION_NOT_SET                       =-9999;
	public static final int RADAR_CROSS_SECTION_NOT_SET             =-9999;
	public static final int VERTICAL_ANGLE_NOT_SET                  =-9999;
	public static final int SHIFT_NOT_SET                          =0;
	public static final int DIRECTION_OF_ERROR_NOT_SET              =-9999;
	public static final int VERTICAL_ANGLE_ERROR_NOT_SET            =-9999;
	public static final int HEIGHT_METER_NOT_SET                    =-1000;
;
	public static final int LATERAL_SHIFT_NOT_SET                  =0;
	public static final int RANGE_SHIFT_NOT_SET                    =0;
	public static final int VERTICAL_SHIFT_NOT_SET                 =0;

	public static final int MAX_COMMENTS_LENGTH                    =1200;
	public static final int MAX_SUBJECT_LENGTH                     =20;

	// DFI DUI CONSTANTS
	public static final int BITS_0275_001_ORIGINATOR_ENVIRONMENT               =2;

	public static final int BITS_0281_014_LATITUDE_0_0051_MINUTE               =21;
	public static final int BITS_0281_015_LATITUDE_0_0013_MINUTE               =23;
	public static final int BITS_0281_017_LATITUDE_0_0103_MINUTE               =20;
	public static final int BITS_0281_402_UNIT_LATITUDE                        =25;
	public static final int BITS_0281_404_OBSERVER_LOCATION_LATITUDE           =25;
	public static final int BITS_0281_407_TARGET_LATITUDE                      =25;
	public static final int BITS_0281_414_GROUND_ZERO_LOCATION_LATITUDE        =25;
	public static final int BITS_0281_415_ATTACK_LOCATION_LATITUDE             =25;
	public static final int BITS_0281_425_PREPOSITIONED_SUPPLY_LATITUDE        =25;
	public static final int BITS_0281_426_SAFE_LANE_LATITUDE                   =31;
	public static final int BITS_0281_461_OBSTACLE_LATITUDE                    =25;
	public static final int BITS_0281_462_BYPASS_LATITUDE                      =25;

	public static final int BITS_0282_013_LONGITUDE_0_0103_MINUTE              =21;
	public static final int BITS_0282_014_LONGITUDE_0_0051_MINUTE              =22;
	public static final int BITS_0282_015_LONGITUDE_0_0013_MINUTE              =24;
	public static final int BITS_0282_402_UNIT_LONGITUDE                       =26;
	public static final int BITS_0282_404_OBSERVER_LOCATION_LONGITUDE          =26;
	public static final int BITS_0282_407_TARGET_LONGITUDE                     =26;
	public static final int BITS_0282_414_GROUND_ZERO_LOCATION_LONGITUDE       =26;
	public static final int BITS_0282_415_ATTACK_LOCATION_LONGITUDE            =26;
	public static final int BITS_0282_425_PREPOSITIONED_SUPPLY_LONGITUDE       =26;
	public static final int BITS_0282_426_SAFE_LANE_LONGITUDE                  =32;
	public static final int BITS_0282_461_OBSTACLE_LONGITUDE                   =26;
	public static final int BITS_0282_462_BYPASS_LONGITUDE                     =26;

	public static final int BITS_0293_003_MODE_I_CODE                          =5;

	public static final int BITS_0294_002_MODE_II_CODE                         =12;

	public static final int BITS_0295_002_MODE_III_CODE                        =12;

	public static final int BITS_0351_009_SQUARE_CIRCLE_SWITCH                 =2;

	public static final int BITS_0365_033_ALTITUDE_25_FT                       =13;

	public static final int BITS_0367_018_SPEED                                =11;
	public static final int BITS_0367_403_UNIT_SPEED_KPH                       =11;

	public static final int BITS_0371_015_COURSE                               =9;

	public static final int BITS_0372_406_DIRECTION_TO_ENEMY                   =9;

	public static final int BITS_0376_401_IDENTITY_VMF                         =4;

	public static final int BITS_0380_001_SECOND                               =6;
	public static final int BITS_0380_412_OBSERVATION_SECOND                   =6;

	public static final int BITS_0385_003_EXERCISE_INDICATOR                   =1;

	public static final int BITS_0386_013_STRENGTH                             =4;

	public static final int BITS_0401_0401_THREAT_POSTURE_VMF                  =3;

	public static final int BITS_0419_001_AREA_MAJOR_AXIS_4                    =4;
	public static final int BITS_0419_002_AREA_MINOR_AXIS_4                    =4;

	public static final int BITS_0749_002_SPACE_SPECIFIC_TYPE                  =12;

	public static final int BITS_0757_403_OBSERVER_ESTIMATED_DISTANCE          =14;

	public static final int BITS_0792_001_HOUR                                 =5;
	public static final int BITS_0792_402_HOUR_ON_TARGET                       =5;
	public static final int BITS_0792_419_OBSERVATION_HOUR                     =5;
	public static final int BITS_0792_420_STRIKE_HOUR                          =5;

	public static final int BITS_0797_004_MINUTE                               =6;
	public static final int BITS_0797_402_MINUTE_ON_TARGET                     =6;
	public static final int BITS_0797_418_OBSERVATION_MINUTE                   =6;
	public static final int BITS_0797_419_STRIKE_MINUTE                        =6;

	public static final int BITS_0804_001_AIR_SPECIFIC_TYPE                    =12;

	public static final int BITS_0808_001_SURFACE_SPECIFIC_TYPE                =12;

	public static final int BITS_0809_001_SUBSURFACE_SPECIFIC_TYPE             =12;

	public static final int BITS_0810_001_LAND_SPECIFIC_TYPE                   =12;

	public static final int BITS_1681_401_TIME_FUNCTION_NBC                    =4;
	public static final int BITS_1681_404_OBSTACLE_TIME_FUNCTION               =3;

	public static final int BITS_1762_002_THREAT_TYPE                          =4;

	public static final int BITS_1768_402_TYPE_OF_NUCLEAR_BURST                =2;

	public static final int BITS_1806_001_AXIS_ORIENTATION                     =8;
	public static final int BITS_1806_401_SYMBOL_AXIS_ORIENTATION              =9;

	public static final int BITS_4002_001_ENGAGEMENT_TYPE                      =2;

	public static final int BITS_4003_001_TARGET_NUMBER_CHARACTERS             =14;
	public static final int BITS_4003_001_TARGET_NUMBER_DIGITS                 =14;  

	public static final int BITS_4004_012_URN                                  =24;
	public static final int BITS_4004_013_UNIT_LONG_NAME                       =448;
	public static final int BITS_4004_014_SUPPLY_POINT_REFERENCE_NUMBER        =24;

	public static final int BITS_4019_001_DAY_OF_MONTH                         =5;
	public static final int BITS_4019_002_DAY_ON_TARGET                        =5;
	public static final int BITS_4019_014_OBSERVATION_DAY                      =5;
	public static final int BITS_4019_015_STRIKE_DAY                           =5;

	public static final int BITS_4029_034_QTY_OF_EQUIPMENT_WEAPONS_OBSERVED    =14; 

	public static final int BITS_4031_002_MINIMUM_SAFE_DISTANCE_1_RADIUS       =10;

	public static final int BITS_4032_006_OBSTACLE_LENGTH                      =10;

	public static final int BITS_4033_006_OBSTACLE_WIDTH                       =10;
	public static final int BITS_4033_013_SAFE_LANE_WIDTH                      =7;

	public static final int BITS_4046_004_ENTITY_ID_SERIAL_NUMBER              =32;

	public static final int BITS_4054_048_INTELLIGENCE_SUBNET_R5_6017          =7;
	public static final int BITS_4054_048_INTELLIGENCE_SUBNET_6017A            =14;

	public static final int BITS_4057_002_FIRE_MISSION_TYPE                    =4;

	public static final int BITS_4058_001_ACTION_DESIGNATOR                    =2;

	public static final int BITS_4075_001_COMMENTS                             =1400;
	public static final int BITS_4075_012_ADDITIONAL_INFORMATION               =140;
	public static final int BITS_4075_014_STAFF_COMMENTS                       =140;
	public static final int BITS_4075_015_UNIQUE_SYMBOL_DESIGNATION            =245;

	public static final int BITS_4079_016_CONVENTIONAL_NUCLEAR_WARNING         =1;
	public static final int BITS_4079_018_LOCATION_QUALIFIER                   =1;

	public static final int BITS_4082_023_ENTITY_COMBAT_STATUS                 =2;
	public static final int BITS_4082_034_IED_STATUS                           =2;

	public static final int BITS_4085_028_EPLRS_RS_ID                          =14;
	public static final int BITS_4085_075_INTELLIGENCE_ENTITY_NUMBER           =28;
	public static final int BITS_4085_076_INTELLIGENCE_NODE_NUMBER             =14;

	public static final int BITS_4093_002_BYPASS_POTENTIAL                     =2;
	public static final int BITS_4093_003_CONTROLLING_FORCE                    =2;

	public static final int BITS_4098_001_YEAR                                 =7;

	public static final int BITS_4099_001_MONTH                                =4;

	public static final int BITS_4102_016_SUPPLY_POINT_TYPE                    =5;

	public static final int BITS_4105_003_ZONE_MARKING                         =4;

	public static final int BITS_4113_001_OBSTACLE_HEIGHT                      =10;

	public static final int BITS_4115_002_TERRAIN_DESCRIPTION                  =4;
	public static final int BITS_4115_003_VEGETATION_TYPE                      =3;

	public static final int BITS_4119_002_LOCATION_DERIVATION                  =4;
	public static final int BITS_4119_005_LOCATION_QUALITY                     =4;

	public static final int BITS_4127_005_NATIONALITY                          =9;

	public static final int BITS_4130_001_ELEVATION_FEET                       =17;
	public static final int BITS_4130_006_OBSERVER_LOCATION_ELEVATION          =17;

	public static final int BITS_4138_002_AGENT_TYPE                           =5;
	public static final int BITS_4138_003_AGENT_PERSISTENCY_TYPE               =2;
	public static final int BITS_4138_004_TYPE_OF_DETECTION                    =4;
	public static final int BITS_4138_006_AGENT_NAME                           =6;

	public static final int BITS_4139_001_BRIDGE_TYPE                          =3;

	public static final int BITS_4152_001_ENEMY_ACTIVITY                       =6;
	public static final int BITS_4152_002_ACTION_TAKEN                         =6;
	public static final int BITS_4152_006_ACTIVITY                             =6;

	public static final int BITS_4153_001_SIZE                                 =5;

	public static final int BITS_4154_001_UNIT_DESIGNATOR                      =175;

	public static final int BITS_4155_005_NBC_INCIDENT_TYPE                    =3;

	public static final int BITS_4161_002_OBSTACLE_DEPTH                       =5;

	public static final int BITS_4165_003_IMPACT_ON_MOVEMENT                   =3;

	public static final int BITS_4170_007_NBC_REPORT_TYPE                      =3;

	public static final int BITS_4173_003_ICON_STATUS                          =1;
	public static final int BITS_4173_014_SYMBOL_DIMENSION                     =5;
	public static final int BITS_4173_015_ENTITY_TYPE                          =6;
	public static final int BITS_4173_016_ENTITY_SUBTYPE                       =6;
	public static final int BITS_4173_018_ICON_SIZE_MOBILITY                   =8;

	public static final int BITS_4205_001_GRAPHICAL_REFERENCE_ENTITY_TYPE      =4;

	public static final int BITS_8001_002_DATA_COMPRESSION_TYPE                =2;
	public static final int BITS_8001_004_FUNCTIONAL_AREA_DESIGNATOR           =4;
	public static final int BITS_8001_005_OPERATION_INDICATOR                  =2;
	public static final int BITS_8001_006_VERSION                              =4;
	public static final int BITS_8001_007_USER_MESSAGE_FORMAT_CODES            =4;
	public static final int BITS_8001_008_MESSAGE_STANDARD_VERSION             =4;
	public static final int BITS_8001_009_MESSAGE_SUBTYPE                      =7;

	public static final int BITS_8002_001_MESSAGE_PRECEDENCE_CODE              =3;
	public static final int BITS_8002_002_SECURITY_CLASSIFICATION              =2;
	public static final int BITS_8002_004_CONTROL_RELEASE_MARKING              =224;

	public static final int BITS_8003_001_RECEIPT_COMPLIANCE                   =3;
	public static final int BITS_8003_002_CANTCO_REASON_CODE                   =3;
	public static final int BITS_8003_004_CANTPRO_REASON_CODE                  =6;

	public static final int BITS_8004_001_REPLY_AMPLIFICATION                  =350;

	public static final int BITS_8005_001_MESSAGE_NUMBER                       =7;
	public static final int BITS_8005_002_MESSAGE_SIZE                         =20;
	public static final int BITS_8005_003_DTG_EXTENSION                        =12;
	public static final int BITS_8005_004_HEADER_SIZE                          =16;

	public static final int BITS_8006_001_FILE_NAME                            =448;

	public static final int BITS_8007_001_MACHINE_ACKNOWLEDGE_REQUEST          =1;
	public static final int BITS_8007_002_OPERATOR_ACKNOWLEDGE_REQUEST         =1;
	public static final int BITS_8007_003_OPERATOR_REPLY_REQUEST               =1;
	public static final int BITS_8007_004_RETRANSMIT_INDICATOR                 =1;

	public static final int BITS_8008_001_SECURITY_PARAMETERS_INFORMATION      =4;
	public static final int BITS_8008_002_KEYING_MATERIAL_ID                   =8;
	public static final int BITS_8008_003_CRYPTOGRAPHIC_INITIALIZATION         =64;
	public static final int BITS_8008_004_KEY_TOKEN                            =64;
	public static final int BITS_8008_005_AUNTHENTICATION_DATA_A               =64;
	public static final int BITS_8008_006_AUNTHENTICATION_DATA_B               =64;
	public static final int BITS_8008_007_SIGNED_ACKNOWLEDGE_REQUEST_INDICATOR =1;
	public static final int BITS_8008_008_MESSAGE_SECURITY_PADDING             =8;

	public static final int BITS_8009_001_KEYING_MATERIAL_ID_LENGTH            =3;
	public static final int BITS_8009_002_CRYPTOGRAPHIC_INITIALIZATION_LENGTH  =4;
	public static final int BITS_8009_003_KEY_TOKEN_LENGTH                     =8;
	public static final int BITS_8009_004_AUTHENTICATION_DATA_A_LENGTH         =7;
	public static final int BITS_8009_005_AUTHENTICATION_DATA_B_LENGTH         =7;
	public static final int BITS_8009_006_MESSAGE_SECURITY_PADDING_LENGTH      =8;

	// Maximum Message Size
	public static final int BYTES_K05_19_6017A_MAXIMUM_MESSAGE_SIZE=2048; //=2MB

	//used in lat long conversion of VmfOps class
	public static final int LATITUDE_402_NO_STATEMENT              =16777216;
	public static final int LONGITUDE_402_NO_STATEMENT             =33554432;
	public static final int LAT_281_402_NO_STATEMENT               =16777216;
	public static final int LONG_282_402_NO_STATEMENT              =33554432;
	public static final int LAT_281_404_NO_STATEMENT               =16777216;
	public static final int LONG_282_404_NO_STATEMENT              =33554432;
	public static final int LAT_281_424_NO_STATEMENT               =16777216;
	public static final int LONG_282_424_NO_STATEMENT              =33554432;
	public static final int LAT_281_014_NO_STATEMENT               =1048576;
	public static final int LONG_282_014_NO_STATEMENT              =2097152;
	public static final int LAT_281_017_NO_STATEMENT               =524288;
	public static final int LONG_282_013_NO_STATEMENT              =1048576;
	public static final int LAT_281_015_NO_STATEMENT               =4194304;
	public static final int LONG_282_015_NO_STATEMENT              =8388608;

	public static final int DIRECTION_ERROR_NOT_SET                =1024;
	public static final int REFERENCE_VERTICAL_ANGLE_NOT_SET       =1601;

	public static final int URN_ACTION_TYPE_REQUEST                =0;
	public static final int URN_ACTION_TYPE_DISTRIBUTE             =1;
	public static final int URN_ACTION_TYPE_NO_DATA_AVAILABLE      =2;
	public static final int URN_ACTION_TYPE_UNDEFINED              =3;
    public static final int TEMPERATURE_NOT_SET                    =-9999;
    public static final int MVV_NOT_SET                            = 1024;	

	// Security Events
	/* DEE - Already defined
	public static final int SE_UNKNOWN                            =0;
	public static final int SE_CHANGE_OF_USER_SENSITIVITY         =1;
	public static final int SE_LOCAL_DISABLE_INITIATED            =2;
	public static final int SE_UNAUTHORIZED_SENSITIVITY_LEVEL     =3;
	public static final int SE_PASSWORD_EXPIRATION_WARNING_ELAPSED=4;
	public static final int SE_LOGON_ATTEMPTS_EXCEEDED            =5;
	public static final int SE_REAUTHENTICATION_REQUEST           =6;
	public static final int SE_REAUTHENTICATION_REQUEST_WLOCKOUT  =7;
	public static final int SE_LOCKOUT_INITIATED                  =8;
	public static final int SE_REAUTHENTICATION_TIMEOUT           =9;
	public static final int SE_SUCCESSFUL_REAUTHENTICATION        =10;
	public static final int SE_REMOTE_DISABLE_COMMAND             =11;
	public static final int SE_REMOTE_DISABLE_INITIATED           =12;
	public static final int SE_PASSWORDS_MODIFIED                 =13;
	public static final int SE_MESSAGE_AUTHENTICATION_FAILURE     =14;
	public static final int SE_SYSTEM_INTRUSION_DETECTED          =15;
	public static final int SE_PUBLIC_KEY_CERT_EXPIRED            =16;
	*/
	public static final int VMF_BROADCAST_URN                     =16777215;



	//
	//// K05.19=6017 Repeat Group Maximums
	//public static final int MAX_K05_19_6017_R1   =64
	//public static final int MAX_K05_19_6017_R1R2 =2
	//public static final int MAX_K05_19_6017_R1R3 =15
	//public static final int MAX_K05_19_6017_R1R4 =2
	//public static final int MAX_K05_19_6017_R1R5 =2
	//public static final int MAX_K05_19_6017_R1R7 =2
	//public static final int MAX_K05_19_6017_R1R8 =2
	//public static final int MAX_K05_19_6017_R1R9 =8
	//public static final int MAX_K05_19_6017_R1R10=8
	//
	//// K05.19=6017A Repeat Group Maximums
	//public static final int MAX_K05_19_6017A_R1  =64
	//public static final int MAX_K05_19_6017A_R2  =3
	//public static final int MAX_K05_19_6017A_R3  =2
	//public static final int MAX_K05_19_6017A_R4  =2
	//public static final int MAX_K05_19_6017A_R5  =15
	//public static final int MAX_K05_19_6017A_R6  =8
	//public static final int MAX_K05_19_6017A_R7  =2
	//public static final int MAX_K05_19_6017A_R8  =2
	//public static final int MAX_K05_19_6017A_R9  =2
	//public static final int MAX_K05_19_6017A_R10 =2
	//public static final int MAX_K05_19_6017A_R11 =2

	
}
