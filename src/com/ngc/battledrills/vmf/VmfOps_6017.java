package ngc.c2pc.vmf.vmfops;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 

public class VmfOps_6017
{

static public boolean IS_VALID_DFINO_275_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_275_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_281_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 1048576) ||
       (dValue >= -90.0 && dValue <= 90.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_281_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 4194304) ||
       (dValue >= -90.0 && dValue <= 90.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_281_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 524288) ||
       (dValue >= -90.0 && dValue <= 90.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_281_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 16777216) ||
       (dValue >= -90.0 && dValue <= 90.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_281_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 1073741824) ||
       (dValue >= -90.0 && dValue <= 90.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_282_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 1048576) ||
       (dValue >= -180.0 && dValue <= 180.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_282_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 2097152) ||
       (dValue >= -180.0 && dValue <= 180.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_282_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 8388608) ||
       (dValue >= -180.0 && dValue <= 180.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_282_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 33554432) ||
       (dValue >= -180.0 && dValue <= 180.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_282_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 2147483648.00) ||
       (dValue >= -180.0 && dValue <= 180.0) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_283_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_293_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_294_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7777) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_295_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7777) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_298_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_351_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_353_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 127.50) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_353_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 4095.94) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_359_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 204750) ||
       (iValue >= 8191 && iValue <= 8191) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_2( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 100 && iValue <= 99900) ||
       (iValue >= 100000 && iValue <= 102300) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 51100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_4( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 131071) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_5( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 32768) ||
       (iValue >= -2100 && iValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2047) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 160) ||
       (sValue >= 166 && sValue <= 166) ||
       (sValue >= 199 && sValue <= 199) ||
       (sValue >= 301 && sValue <= 460) ||
       (sValue >= 466 && sValue <= 466) ||
       (sValue >= 477 && sValue <= 477) ||
       (sValue >= 499 && sValue <= 499) ||
       (sValue >= 501 && sValue <= 660) ||
       (sValue >= 666 && sValue <= 666) ||
       (sValue >= 677 && sValue <= 677) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_9( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 262143) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_10( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 65535) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_11( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 65535) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_365_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 32767) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4092) ||
       (sValue >= 2047 && sValue <= 2047) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2047) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 300) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1270) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1270) ||
       (sValue >= -1270 && sValue <= -10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 116) ||
       (sValue >= 120 && sValue <= 120) ||
       (sValue >= 31 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_11( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 12.70) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_13( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 0.00) ||
       (dValue >= 0.25 && dValue <= 8191.75) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_367_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2047) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_369_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 0) ||
       (sValue >= 5 && sValue <= 360) ||
       (sValue >= 365 && sValue <= 365) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) ||
       (sValue >= 511 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 350) ||
       (sValue >= 63 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 0) ||
       (sValue >= 10 && sValue <= 360) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 0) ||
       (sValue >= 5 && sValue <= 360) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_371_DISET_12( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 359.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 359.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 0.00) ||
       (dValue >= 0.10 && dValue <= 90.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 360) ||
       (sValue >= 511 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 90) ||
       (sValue >= -90 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_372_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_376_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 59) ||
       (sValue >= 63 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 9.90) ||
       (dValue >= -9.90 && dValue <= -0.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 200.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 999.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_380_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) ||
       (sValue >= -127 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_385_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_386_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_399_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_401_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_409_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 409400) ||
       (iValue >= 4095 && iValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_417_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_417_DISET_2( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_419_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_434_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_435_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 0.00) ||
       (dValue >= 0.05 && dValue <= 819.15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_440_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 0.00) ||
       (dValue >= 0.10 && dValue <= 53687091.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_700_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_700_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_730_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_749_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_753_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_753_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_753_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_753_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 12500) ||
       (sValue >= 12600 && sValue <= 12600) ||
       (sValue >= 127 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 32767) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_4( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 131071) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_6( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 100 && iValue <= 102300) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 10 && sValue <= 10230) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_8( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 16383.50) ||
       (dValue >= -16383.50 && dValue <= -0.50) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_9( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 65535) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_10( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 4194303) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_12( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_13( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 102.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_16( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1000 && iValue <= 511000) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_757_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_792_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 23) ||
       (sValue >= 31 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_792_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 23.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_792_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 23) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_797_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 59) ||
       (sValue >= 63 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_797_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 59) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_804_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_808_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_809_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_810_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1641_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1643_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1681_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1681_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1681_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1681_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1681_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1762_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1768_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1806_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 179) ||
       (sValue >= 255 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1806_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) ||
       (sValue >= 511 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1812_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1819_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1820_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1820_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1849_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_1898_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4002_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4002_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4003_DISET_1( String csValue )
{
  boolean bIsValid = false;

  String csTargetNumber = csValue.substring(0,2);
  String csNumeric = csValue.substring(2, csValue.length());

  int sTargetNumber = Integer.valueOf(csNumeric);

  if ( sTargetNumber >= 0 && sTargetNumber <= 9999 && csTargetNumber.length() == 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csTargetNumber.length(); i++)
    {
      char cRaw = (char) csTargetNumber.charAt(i);

      if ( (cRaw >= 0 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }

  return bIsValid;
}
static public boolean IS_VALID_DFINO_4003_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 11 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw == 47) ||
           (cRaw >= 58 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4003_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 8 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw == 47) ||
           (cRaw >= 58 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4003_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 5 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4003_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4004_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 32 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 63) ||
           (cRaw >= 91 && cRaw <= 96) ||
           (cRaw >= 123 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4004_DISET_2( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 16777215) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4004_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 64 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4004_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 30 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4005_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4006_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 26) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4007_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4008_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4009_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 999) ||
       (sValue >= 1024 && sValue <= 1024) ||
       (sValue >= -999 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4010_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4011_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 9) ||
       (sValue >= 11 && sValue <= 19) ||
       (sValue >= 21 && sValue <= 29) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4011_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4011_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4011_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4011_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4012_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 4095) ||
       (sValue >= -4095 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4012_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 10230) ||
       (sValue >= -10230 && sValue <= -10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4013_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4014_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4015_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue == 0.00) ||
       (dValue >= 0.50 && dValue <= 4194303.50) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4017_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 600 && sValue <= 1100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 25.00 && dValue <= 32.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 28.00 && dValue <= 31.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1100.00) ||
       (dValue == 16383.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4018_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 21) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4019_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 8191) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 60) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4020_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 20) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 27) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 25) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4021_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4023_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 500.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4023_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) ||
       (sValue >= -63 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4023_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 200) ||
       (sValue >= -130 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4023_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 50.00) ||
       (dValue >= 50.10 && dValue <= 102.20) ||
       (dValue == 102.30) ||
       (dValue == 1024.00) ||
       (dValue >= 102.50 && dValue <= 114.70) ||
       (dValue >= -90.00 && dValue <= -0.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4025_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4025_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4026_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4027_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 6399) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 6400.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3200) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1600) ||
       (sValue >= -400 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1600) ||
       (sValue >= -1600 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) ||
       (sValue >= -1023 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) ||
       (sValue >= -1023 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 0) ||
       (sValue >= 10 && sValue <= 6400) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_10( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1556.00) ||
       (dValue >= -399.90 && dValue <= -0.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 6390) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1600) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_14( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 6399.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_15( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1600.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 800) ||
       (sValue >= -800 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4028_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 6300) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 99) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 24) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 99) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 5 && sValue <= 635) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_13( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 131071) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_14( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2047) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_23( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_24( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_26( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 12) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_27( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_28( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 2 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_29( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_30( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_31( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 706) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_32( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_33( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 16777215) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_34( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_35( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_36( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 10485.75) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_37( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_38( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_39( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4029_DISET_40( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4030_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4031_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4031_DISET_2( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 100 && iValue <= 99900) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4031_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 99999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4031_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4031_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 999.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4032_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4032_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 99.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4032_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4032_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 999.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4032_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 102.20) ||
       (dValue == 102.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 99999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 999.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4033_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4034_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4035_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 600.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 60) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 11 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_13( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1638.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4037_DISET_14( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 30.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4038_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1638.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4038_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4039_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4039_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1638.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4040_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4040_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4041_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4041_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4041_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4041_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4043_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4043_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 26) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4045_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4046_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 9999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4046_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4046_DISET_3( long lValue )
{
  boolean bIsValid = false;
  if ( lValue >= 0.0 && lValue <= 4294967295.0 ) 
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4047_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4047_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4047_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4048_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4049_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4050_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4051_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 5) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4051_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4051_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4052_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4053_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4053_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 12) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 15 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 30 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 6 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 12 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_5( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_6( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 1 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_7( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 9 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_8( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 10 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_9( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 20 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 97 && cRaw <= 122) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_10( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 9 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_11( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 32 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 97 && cRaw <= 122) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_12( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 14 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 97 && cRaw <= 122) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_13( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 8 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_14( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 16 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 44) ||
           (cRaw >= 46 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_15( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 4 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_16( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 4 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_17( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 1 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 71 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_18( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 5 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_19( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 1 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4054_DISET_20( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 64 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4055_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4055_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4056_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 25 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 34 && cRaw <= 42) ||
           (cRaw == 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) ||
       (sValue >= 3 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_23( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_24( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_26( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_27( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_28( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_29( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_30( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_31( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4057_DISET_32( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4058_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4059_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4060_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 240) ||
       (sValue >= -240 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4063_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4065_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4065_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4066_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4067_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4067_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4067_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4067_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4067_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4068_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4068_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 100.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4068_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 9.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4069_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4069_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4069_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4070_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4072_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 9999) ||
       (sValue >= -9999 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4074_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 200 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 8) ||
           (cRaw >= 11 && cRaw <= 12) ||
           (cRaw >= 14 && cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 32 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 14 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw >= 59 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 20 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_5( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 24 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 97 && cRaw <= 122) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_6( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 35 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw >= 59 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4075_DISET_7( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 10 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 42) ||
           (cRaw >= 60 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4077_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4077_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_23( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_24( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_26( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_27( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_28( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_29( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_30( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_31( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_32( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_33( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_34( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_35( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_36( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_37( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_38( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_39( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_40( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_41( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_42( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_43( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_44( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_45( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_46( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_47( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_48( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_49( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_50( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_51( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_52( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_53( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_54( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_55( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_56( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_57( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_58( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_59( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_60( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_61( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_62( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_63( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_64( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_65( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_66( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_67( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_68( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_69( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_70( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_71( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_72( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_73( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_74( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_75( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_76( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_77( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_78( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_79( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_80( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_81( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_82( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_83( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_84( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_85( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_86( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_87( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_88( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_89( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_90( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_91( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_92( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_93( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_94( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_95( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_96( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_97( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4079_DISET_98( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4081_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4082_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4083_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 999999999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 300) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_17( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 11111 && iValue <= 88888) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 26) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 20) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_23( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_24( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_26( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_27( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 8) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_28( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_29( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 10 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_30( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 98999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_31( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 268435455) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_32( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4085_DISET_33( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4088_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 2047.94) ||
       (dValue >= -2047.94 && dValue <= -0.06) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4088_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4088_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 99.90) ||
       (dValue == 1024.00) ||
       (dValue >= -99.90 && dValue <= -0.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4088_DISET_4( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 1638.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 5) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_10( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_11( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_12( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_13( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_14( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 5) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_15( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_16( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_17( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_18( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_19( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_20( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_21( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_22( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_23( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_24( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_25( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_26( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_27( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_28( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_29( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_30( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_31( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_32( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_33( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_34( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_35( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_36( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_37( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_38( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_39( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_40( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_41( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_42( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_43( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_44( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_45( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_46( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_47( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_48( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_49( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_50( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_51( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_52( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_53( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4093_DISET_54( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4097_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4098_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 2000 && sValue <= 2094) ||
       (sValue >= 1995 && sValue <= 1999) ||
       (sValue >= 100 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4099_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 12) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4100_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 17 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_1( short sValue )
{
  boolean bIsValid = false;
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 60 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 97 && cRaw <= 122) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4102_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4103_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4104_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 8 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 45) ||
           (cRaw == 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4105_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4106_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 4095) ||
       (sValue >= -4095 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4106_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4095) ||
       (sValue >= -4095 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4106_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 10230) ||
       (sValue >= -10230 && sValue <= -10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4107_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4107_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4109_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4109_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 99.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4110_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4113_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4113_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4113_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4113_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4113_DISET_5( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 131071) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4114_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4114_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4115_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4115_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4115_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4116_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4116_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4117_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4117_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4118_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4118_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4119_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4119_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4119_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4119_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4121_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4122_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4122_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4123_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4123_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 99.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4123_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1000 && iValue <= 200000) ||
       (iValue >= 200050 && iValue <= 204750) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4123_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 10 && sValue <= 2000) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4123_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4124_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4125_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4126_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4126_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4126_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4126_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4127_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4127_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4127_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4127_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 3 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4129_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4129_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4129_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4129_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4130_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 65535) ||
       (iValue >= -1320 && iValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4130_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9990) ||
       (sValue >= -990 && sValue <= -10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4130_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 32808.90) ||
       (dValue >= -1319.90 && dValue <= -0.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4131_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4131_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4131_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4132_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4132_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4133_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 16383) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4134_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4134_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4135_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4135_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 359) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4135_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4136_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4138_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4139_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4139_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4139_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4139_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4140_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4140_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 1638.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4140_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 204700) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4141_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4141_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4141_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4142_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 100) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4142_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4142_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4143_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4143_DISET_3( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 10000000) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4143_DISET_4( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 10000000) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4144_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4144_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4144_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.20 && dValue <= 2.00) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4144_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4144_DISET_5( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 102.30) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4145_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4145_DISET_2( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 99999.90) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4147_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4148_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 5 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4148_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4148_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 511) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4148_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4148_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4149_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4150_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 20 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 44) ||
           (cRaw >= 46 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4150_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4150_DISET_7( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 10 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 44) ||
           (cRaw >= 46 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4150_DISET_8( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 3 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4151_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4151_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 1 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4152_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4152_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4152_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4152_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4153_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4153_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4154_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 25 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw >= 59 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4155_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4155_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4155_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4155_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4156_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4156_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4156_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4156_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4156_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 8) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4159_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4160_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4161_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4161_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4161_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 12.70) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4161_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1023) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4162_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4163_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4164_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4165_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4165_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4165_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4165_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 14 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 42) ||
           (cRaw == 44) ||
           (cRaw == 46) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_6( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 3 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4166_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4167_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4168_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4169_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4170_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4171_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4172_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 21 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) ||
           (cRaw >= 33 && cRaw <= 39) ||
           (cRaw >= 42 && cRaw <= 43) ||
           (cRaw >= 59 && cRaw <= 62) ||
           (cRaw == 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4173_DISET_10( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 15 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 41) ||
           (cRaw >= 43 && cRaw <= 44) ||
           (cRaw >= 46 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4174_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 4) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4175_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4176_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4176_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4176_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4176_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4176_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4177_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4177_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4177_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4177_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4177_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4178_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4179_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 99) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4179_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 999) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4180_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 6) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4180_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 2) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4180_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4181_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4191_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4191_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4191_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4192_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4192_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 31) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4192_DISET_3( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.00 && dValue <= 9999999.99) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4192_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 9999) ||
       (sValue >= -9999 && sValue <= -1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4193_DISET_1( double dValue )
{
  boolean bIsValid = false;
  if ( (dValue >= 0.10 && dValue <= 13017.10) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4193_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4194_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4203_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 65535) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4205_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4210_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4210_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_4211_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8001_DISET_9( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8002_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8002_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 3) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8002_DISET_3( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 2 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 47) ||
           (cRaw >= 58 && cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 127) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8002_DISET_4( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 32 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 64) ||
           (cRaw >= 91 && cRaw <= 126) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8003_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8003_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8003_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8003_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 63) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8004_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 50 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8005_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8005_DISET_2( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 1048575) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8005_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 1 && sValue <= 4095) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8005_DISET_4( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 1 && iValue <= 65535) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8006_DISET_1( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 64 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

    }
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8007_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8007_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8007_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8007_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_7( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8008_DISET_8( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 1) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_1( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 7) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_2( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 15) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_3( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_4( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_5( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 127) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8009_DISET_6( short sValue )
{
  boolean bIsValid = false;
  if ( (sValue >= 0 && sValue <= 255) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8010_DISET_1( int iValue )
{
  boolean bIsValid = false;
  if ( (iValue >= 0 && iValue <= 16777215) )
  {
    bIsValid = true;
  }
 
  return bIsValid;
}

static public boolean IS_VALID_DFINO_8010_DISET_2( String csValue )
{
  boolean bIsValid = false;

  if ( csValue.length() <= 64 )
  {
    bIsValid = true;

    for (int i = 0; i < csValue.length(); i++)
    {
      char cRaw = (char) csValue.charAt(i);

      if ( (cRaw <= 31) )
      {
        bIsValid = false;
      }
    }
  }
 
  return bIsValid;
}



};

