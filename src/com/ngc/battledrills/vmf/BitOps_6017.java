package ngc.c2pc.vmf.bitops;


public class BitOps_6017
{

static private boolean __isascii( char uValue )
{
  boolean isAscii = false;

  if( (uValue >=0) && (uValue <= 0x7F) )
  {
    isAscii = true;
  }

  return isAscii;
}

  // GetIndicatorBit Methods
  public static boolean GET_GPI( char[] pMsg, int[] nBitOffset, int nTotalBits )
  { return GET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits ); }
  public static boolean GET_GRI( char[] pMsg, int[] nBitOffset, int nTotalBits )
  { return GET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits ); }
  public static boolean GET_FPI( char[] pMsg, int[] nBitOffset, int nTotalBits )
  { return GET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits ); }
  public static boolean GET_FRI( char[] pMsg, int[] nBitOffset, int nTotalBits )
  { return GET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits ); }

  // SetIndicatorBit Methods
  public static boolean SET_GPI( char[] pMsg, int[] nBitOffset, int nTotalBits, boolean bIsSet )
  { return SET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits, bIsSet ); }
  public static boolean SET_GRI( char[] pMsg, int[] nBitOffset, int nTotalBits, boolean bIsSet )
  { return SET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits, bIsSet ); }
  public static boolean SET_FPI( char[] pMsg, int[] nBitOffset, int nTotalBits, boolean bIsSet )
  { return SET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits, bIsSet ); }
  public static boolean SET_FRI( char[] pMsg, int[] nBitOffset, int nTotalBits, boolean bIsSet )
  { return SET_INDICATOR_BIT( pMsg, nBitOffset, nTotalBits, bIsSet ); }

static public boolean GET_DFINO_281_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

    long[] uiValue = new long[1];
    uiValue[0] = 0;
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == (long)0L)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long)1 && uiValue[0] <= 1048575)
    {
      dValue[0] = ((double)uiValue[0]) * 8.58307703312E-05;
      if (dValue[0] > 90.0) 
      { 
        dValue[0] = 90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 1048577 && uiValue[0] <= 2097151)
    {
      dValue[0] = ((double)uiValue[0] - 2097152) * 8.58307703312E-05;
      if (dValue[0] < -90.0) 
      { 
        dValue[0] = -90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 1048576)
    {
      dValue[0] = 1048576.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_281_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
   boolean bIsValid = false;

   long[] uiValue = new long[1];
    
   if ( dValue == 0)
   {
     uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 90)
  {
    uiValue[0] = (long)( dValue / 8.58307703312E-05);
  }
  else if ( dValue >= -90 && dValue <= 0)
  {
    uiValue[0] = (long)(dValue / 8.58307703312E-05 + 2097152.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
 
static public boolean GET_DFINO_281_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

    long[] uiValue = new long[1];
    uiValue[0] = 0;
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == (long)0L)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long)1 && uiValue[0] <= 4194303)
    {
      dValue[0] = ((double)uiValue[0]) * 2.1457677235E-05;
      if (dValue[0] > 90.0) 
      { 
        dValue[0] = 90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 4194305 && uiValue[0] <= 8388607)
    {
      dValue[0] = ((double)uiValue[0] - 8388608) * 2.1457677235E-05;
      if (dValue[0] < -90.0) 
      { 
        dValue[0] = -90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 4194304)
    {
      dValue[0] = 4194304.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_281_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
   boolean bIsValid = false;

   long[] uiValue = new long[1];
    
   if ( dValue == 0)
   {
     uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 90)
  {
    uiValue[0] = (long)( dValue / 2.1457677235E-05);
  }
  else if ( dValue >= -90 && dValue <= 0)
  {
    uiValue[0] = (long)(dValue / 2.1457677235E-05 + 8388608.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
 
static public boolean GET_DFINO_281_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

    long[] uiValue = new long[1];
    uiValue[0] = 0;
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == (long)0L)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long)1 && uiValue[0] <= 524287)
    {
      dValue[0] = ((double)uiValue[0]) * 0.000171661704372;
      if (dValue[0] > 90.0) 
      { 
        dValue[0] = 90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 524289 && uiValue[0] <= 1048575)
    {
      dValue[0] = ((double)uiValue[0] - 1048576) * 0.000171661704372;
      if (dValue[0] < -90.0) 
      { 
        dValue[0] = -90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 524288)
    {
      dValue[0] = 524288.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_281_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
   boolean bIsValid = false;

   long[] uiValue = new long[1];
    
   if ( dValue == 0)
   {
     uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 90)
  {
    uiValue[0] = (long)( dValue / 0.000171661704372);
  }
  else if ( dValue >= -90 && dValue <= 0)
  {
    uiValue[0] = (long)(dValue / 0.000171661704372 + 1048576.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
 
static public boolean GET_DFINO_281_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

    long[] uiValue = new long[1];
    uiValue[0] = 0;
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == (long)0L)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long)1 && uiValue[0] <= 16777215)
    {
      dValue[0] = ((double)uiValue[0]) * 5.36441834953E-06;
      if (dValue[0] > 90.0) 
      { 
        dValue[0] = 90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 16777217 && uiValue[0] <= 33554431)
    {
      dValue[0] = ((double)uiValue[0] - 33554432) * 5.36441834953E-06;
      if (dValue[0] < -90.0) 
      { 
        dValue[0] = -90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 16777216)
    {
      dValue[0] = 16777216.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_281_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
   boolean bIsValid = false;

   long[] uiValue = new long[1];
    
   if ( dValue == 0)
   {
     uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 90)
  {
    uiValue[0] = (long)( dValue / 5.36441834953E-06);
  }
  else if ( dValue >= -90 && dValue <= 0)
  {
    uiValue[0] = (long)(dValue / 5.36441834953E-06 + 33554432.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
 
static public boolean GET_DFINO_281_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

    long[] uiValue = new long[1];
    uiValue[0] = 0;
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == (long)0L)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long)1 && uiValue[0] <= 1073741823)
    {
      dValue[0] = ((double)uiValue[0]) * 8.38190317935E-08;
      if (dValue[0] > 90.0) 
      { 
        dValue[0] = 90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 1073741825 && uiValue[0] <= 2147483647)
    {
      dValue[0] = ((double)uiValue[0] - 1073741824) * -8.38190317935E-08;
      if (dValue[0] < -90.0) 
      { 
        dValue[0] = -90.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 1073741824)
    {
      dValue[0] = 1073741824.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_281_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
   boolean bIsValid = false;

   long[] uiValue = new long[1];
    
   if ( dValue == 0)
   {
     uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 90)
  {
    uiValue[0] = (long)((long) dValue / 8.38190317935E-08);
  }
  else if ( dValue >= -90 && dValue <= 0)
  {
    uiValue[0] = (long)(dValue / 8.38190317935E-08 + 2147483648.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
 
static public boolean GET_DFINO_282_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == 0)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= 1 && uiValue[0] <= 1048575)
    {
      dValue[0] = (double)(uiValue[0] * 0.000171661540662);
      if (dValue[0] > 180.0) 
      { 
        dValue[0] = 180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= 1048577 && uiValue[0] <= 2097151)
    {
      dValue[0] = (double)((uiValue[0] - 2097152) * 0.000171661540662);
      if (dValue[0] < -180.0) 
      { 
        dValue[0] = -180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 1048576.00)
    {
      dValue[0] = 1048576.0;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_282_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( dValue == 0)
  {
    uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 180)
  {
    uiValue[0] = (long) (dValue / 0.000171661540662);
  }
  else if ( dValue >= -180 && dValue <= 0)
  {
    uiValue[0] = (long) (dValue / 0.000171661540662 + 2097152);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
static public boolean GET_DFINO_282_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == 0)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 1 && uiValue[0] <= (long)2097151.00)
    {
      dValue[0] = (double)(uiValue[0] * 8.58307294038E-05);
      if (dValue[0] > 180.0) 
      { 
        dValue[0] = 180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 2097153 && uiValue[0] <= 4194303)
    {
      dValue[0] = (double)((uiValue[0] - 4194304) * 8.58307294038E-05);
      if (dValue[0] < -180.0) 
      { 
        dValue[0] = -180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 2097152.00)
    {
      dValue[0] = 2097152.00;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_282_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( dValue == 0)
  {
    uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 180)
  {
    uiValue[0] = (long) (dValue / 8.58307294038E-05);
  }
  else if ( dValue >= -180 && dValue <= 0)
  {
    uiValue[0] = (long) (dValue / 8.58307294038E-05 + 4194304);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
static public boolean GET_DFINO_282_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == 0)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 1 && uiValue[0] <= 8388607)
    {
      dValue[0] = (double)((uiValue[0]) * 2.14576746771E-05);
      if (dValue[0] > 180.0) 
      { 
        dValue[0] = 180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 8388609 && uiValue[0] <= (long)16777215.00)
    {
      dValue[0] = (double)((uiValue[0] - 16777216.00) * 2.14576746771E-05);
      if (dValue[0] < -180.0) 
      { 
        dValue[0] = -180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 8388608)
    {
      dValue[0] = 8388608.00;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_282_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( dValue == 0)
  {
    uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 180)
  {
    uiValue[0] = (long) (dValue / 2.14576746771E-05);
  }
  else if ( dValue >= -180 && dValue <= 0)
  {
    uiValue[0] = (long) (dValue / 2.14576746771E-05 + 16777216.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
static public boolean GET_DFINO_282_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == 0)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= 1 && uiValue[0] <= 33554431)
    {
      dValue[0] = (double)(uiValue[0] * 5.36441818966E-06);
      if (dValue[0] > 180.0) 
      { 
        dValue[0] = 180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 33554433.00 && uiValue[0] <= (long) 67108863.00)
    {
      dValue[0] = (double)((uiValue[0] - 67108864.00) * 5.36441818966E-06);
      if (dValue[0] < -180.0) 
      { 
        dValue[0] = -180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 33554432.00)
    {
      dValue[0] = 33554432.00;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_282_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( dValue == 0)
  {
    uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 180)
  {
    uiValue[0] = (long) (dValue / 5.36441818966E-06);
  }
  else if ( dValue >= -180 && dValue <= 0)
  {
    uiValue[0] = (long) (dValue / 5.36441818966E-06 + 67108864.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
static public boolean GET_DFINO_282_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if ( uiValue[0] == 0)
    {
      dValue[0] = 0.0;
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 1 && uiValue[0] <= (long) 2147483647.00)
    {
      dValue[0] = (double)(uiValue[0] * 8.38190317544E-08);
      if (dValue[0] > 180.0) 
      { 
        dValue[0] = 180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] >= (long) 2147483649.00 && uiValue[0] <= (long) 4294967295.00)
    {
      dValue[0] = (double)((uiValue[0] - 4294967296.00) * 8.38190317544E-08);
      if (dValue[0] < -180.0) 
      { 
        dValue[0] = -180.0; 
      } 
      bIsValid = true;
    }
    else if ( uiValue[0] == (long) 2147483648.00)
    {
      dValue[0] = 2147483648.00;
      bIsValid = true;
    }
  }
  return bIsValid;
}
 
static public boolean SET_DFINO_282_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  
  if ( dValue == 0)
  {
    uiValue[0] = (long) dValue;
  }
  else if ( dValue >= 0 && dValue <= 180)
  {
    uiValue[0] = (long) (dValue / 8.38190317544E-08);
  }
  else if ( dValue >= -180 && dValue <= 0)
  {
    uiValue[0] = (long) (dValue / 8.38190317544E-08 + 4294967296.00);
  }
  else
  {
    uiValue[0] = (long) dValue;
  }
  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}
 
static public boolean GET_DFINO_353_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)255L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.5 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_353_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 127.5)
    uiValue[0] = (long) ((dValue + 0.00) / 0.5 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_353_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)65535L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.0625 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_353_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 4095.9375)
    uiValue[0] = (long) ((dValue + 0.00) / 0.0625 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_365_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)8190L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 25 + 0;
      bIsValid = true;
    } else if (uiValue[0] >= (long)8191L && uiValue[0] <= (long)8191L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 1 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_365_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 0 && iValue <= 204750)
    uiValue[0] = (long) ((iValue + 0.00) / 25 + 0.00);
  else if (iValue >= 8191 && iValue <= 8191)
    uiValue[0] = (long) ((iValue + 0.00) / 1 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_365_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)999L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_365_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 100 && iValue <= 99900)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_365_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)511L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_365_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 0 && iValue <= 51100)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_365_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)32767L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 1 + 0;
      bIsValid = true;
    } else if (uiValue[0] >= (long)63436L && uiValue[0] <= (long)65535L) { 
      iValue[0] = ((int)uiValue[0] - 65536) * 1 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_365_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 0 && iValue <= 32767)
    uiValue[0] = (long) ((iValue + 0.00) / 1 + 0.00);
  else if (iValue >= -2100 && iValue <= -1)
    uiValue[0] = (long) ((iValue + 0.00) / 1 + 65536.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)2046L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 2) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 4092)
    uiValue[0] = (long) ((sValue + 0.00) / 2 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)127L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1270)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)127L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)129L && uiValue[0] <= (long)255L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 256.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1270)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else if (sValue >= -1270 && sValue <= -10)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 256.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)29L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 4) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)30L && uiValue[0] <= (long)30L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 4) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 116)
    uiValue[0] = (long) ((sValue + 0.00) / 4 + 0.00);
  else if (sValue >= 120 && sValue <= 120)
    uiValue[0] = (long) ((sValue + 0.00) / 4 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_11( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)127L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_11( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 12.7)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_367_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)0L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1L && uiValue[0] <= (long)32767L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.25 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_367_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue == 0)
   uiValue[0] = (long) dValue; 
  else if (dValue >= 0.25 && dValue <= 8191.75)
    uiValue[0] = (long) ((dValue + 0.00) / 0.25 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_371_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)72L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 5) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)73L && uiValue[0] <= (long)73L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 5) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_371_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 5 && sValue <= 360)
    uiValue[0] = (long) ((sValue + 0.00) / 5 + 0.00);
  else if (sValue >= 365 && sValue <= 365)
    uiValue[0] = (long) ((sValue + 0.00) / 5 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_371_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)35L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_371_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 350)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_371_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)36L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_371_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 10 && sValue <= 360)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_371_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)72L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 5) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_371_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 5 && sValue <= 360)
    uiValue[0] = (long) ((sValue + 0.00) / 5 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_371_DISET_12( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)3599L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_371_DISET_12( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 359.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_372_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)3599L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_372_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 359.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_372_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)900L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_372_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 90)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_372_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)90L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)166L && uiValue[0] <= (long)255L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 256.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_372_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 90)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -90 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 256.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_380_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)99L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)157L && uiValue[0] <= (long)255L) { 
      dValue[0] = ((double)uiValue[0] - 256.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_380_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 9.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= -9.9 && dValue <= -0.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 256.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_380_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)2000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_380_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 200)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_380_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)9999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_380_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 999.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_380_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)127L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)129L && uiValue[0] <= (long)255L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 256.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_380_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 127)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -127 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 256.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_409_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)4094L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_409_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 0 && iValue <= 409400)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_435_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.05 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_435_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.05 && dValue <= 819.15)
    uiValue[0] = (long) ((dValue + 0.00) / 0.05 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_440_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)0L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1L && uiValue[0] <= (long)536870911L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_440_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue == 0)
   uiValue[0] = (long) dValue; 
  else if (dValue >= 0.1 && dValue <= 53687091.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)125L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 100) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)126L && uiValue[0] <= (long)126L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 100) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 12500)
    uiValue[0] = (long) ((sValue + 0.00) / 100 + 0.00);
  else if (sValue >= 12600 && sValue <= 12600)
    uiValue[0] = (long) ((sValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)1023L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 100 && iValue <= 102300)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)1023L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 10 && sValue <= 10230)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)32767L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.5 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)32769L && uiValue[0] <= (long)65535L) { 
      dValue[0] = ((double)uiValue[0] - 65536.00) * 0.5 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 16383.5)
    uiValue[0] = (long) ((dValue + 0.00) / 0.5 + 0.00);
  else if (dValue >= -16383.5 && dValue <= -0.5)
    uiValue[0] = (long) ((dValue + 0.00) / 0.5 + 65536.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1023L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 102.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_757_DISET_16( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)511L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 1000 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_757_DISET_16( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 1000 && iValue <= 511000)
    uiValue[0] = (long) ((iValue + 0.00) / 1000 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_792_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)239L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_792_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 23.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4003_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, String[] csValue, short[] sValue )
{
  boolean bIsValid = false;

  if ( GET_ASCII_TEXT( pMsg, nBitOffset, nTotalBits, 14, csValue ) )
  {
    long[] uiValue = new long[1];
    uiValue[0] = 0;
    
    if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, 14, uiValue ) )
    {
      if ( uiValue[0] <= 9999 )
      {
        sValue[0] = (short) uiValue[0];
        bIsValid = true;
      }
    }
  }
   
  return bIsValid;
}
 
static public boolean SET_DFINO_4003_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, String csValue, short sValue )
{
  boolean bIsValid = false;
 
  if ( SET_ASCII_TEXT( pMsg, nBitOffset, nTotalBits, 14, csValue ) &&
       SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, 14, sValue ) )
  {
    bIsValid = true;
  }

  return bIsValid;
}

static public boolean GET_DFINO_4009_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)0L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1L && uiValue[0] <= (long)999L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1049L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4009_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue == 0)
   uiValue[0] = (long) sValue; 
  else if (sValue >= 1 && sValue <= 999)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -999 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4012_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)4095L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)4097L && uiValue[0] <= (long)8191L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 8192.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4012_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 1 && sValue <= 4095)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -4095 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 8192.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4012_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1023L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1025L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4012_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 10230)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else if (sValue >= -10230 && sValue <= -10)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4015_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)8388607L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.5 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4015_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.5 && dValue <= 4194303.5)
    uiValue[0] = (long) ((dValue + 0.00) / 0.5 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4018_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)700L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.01 + 25.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4018_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 25 && dValue <= 32)
    uiValue[0] = (long) ((dValue + -25.00) / 0.01 - 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4018_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)300L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.01 + 28.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4018_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 28 && dValue <= 31)
    uiValue[0] = (long) ((dValue + -28.00) / 0.01 - 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4018_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)11000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4018_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1100)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4023_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)5000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4023_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 500)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4023_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)63L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)65L && uiValue[0] <= (long)127L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 128.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4023_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 63)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -63 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 128.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4023_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)200L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)382L && uiValue[0] <= (long)511L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 512.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4023_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 200)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -130 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 512.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4023_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)500L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1023L && uiValue[0] <= (long)1023L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1148L && uiValue[0] <= (long)2047L) { 
      dValue[0] = ((double)uiValue[0] - 2048.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4023_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 50)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= 102.3 && dValue <= 102.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= -90 && dValue <= -0.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 2048.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)6399999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.001 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 6399.999)
    uiValue[0] = (long) ((dValue + 0.00) / 0.001 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)32L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 100) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 3200)
    uiValue[0] = (long) ((sValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1600L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)3696L && uiValue[0] <= (long)4095L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 4096.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1600)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -400 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 4096.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1600L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)2496L && uiValue[0] <= (long)4095L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 4096.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1600)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -1600 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 4096.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1023L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1025L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_7( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1023)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -1023 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1023L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1025L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_8( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 1023)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -1023 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)640L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 10 && sValue <= 6400)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)15560L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)28769L && uiValue[0] <= (long)32767L) { 
      dValue[0] = ((double)uiValue[0] - 32768.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_10( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1556)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= -399.9 && dValue <= -0.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 32768.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_12( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)639L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_12( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 6390)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_14( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)63999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_14( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 6399.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_15( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)16000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_15( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1600)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_16( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)800L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1248L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_16( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 800)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -800 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4028_DISET_17( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)63L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 100) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4028_DISET_17( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 6300)
    uiValue[0] = (long) ((sValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4029_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)127L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 5) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4029_DISET_9( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 5 && sValue <= 635)
    uiValue[0] = (long) ((sValue + 0.00) / 5 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4029_DISET_36( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1048575L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.01 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4029_DISET_36( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 10485.75)
    uiValue[0] = (long) ((dValue + 0.00) / 0.01 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4031_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)999L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4031_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 100 && iValue <= 99900)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4031_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)9999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4031_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 999.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4032_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4032_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 99.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4032_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)9999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4032_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 999.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4033_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)1022L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1023L && uiValue[0] <= (long)1023L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4033_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 102.2)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= 102.3 && dValue <= 102.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4033_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)9999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4033_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 999.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4037_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)6000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4037_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 600)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4037_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4037_DISET_13( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1638.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4037_DISET_14( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)65535L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.00045776 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4037_DISET_14( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 29.9993016)
    uiValue[0] = (long) ((dValue + 0.00) / 0.00045776 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4038_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4038_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1638.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4039_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4039_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1638.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4060_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)240L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)272L && uiValue[0] <= (long)511L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 512.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4060_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 240)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -240 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 512.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4068_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)1000L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4068_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 100)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4068_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)99L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4068_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 9.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4072_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)9999L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)22769L && uiValue[0] <= (long)32767L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 32768.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4072_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 1 && sValue <= 9999)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -9999 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 32768.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4085_DISET_27( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)7L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 1.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4085_DISET_27( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 1 && sValue <= 8)
    uiValue[0] = (long) ((sValue + -1.00) / 1 - 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4088_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)32767L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.0625 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)32769L && uiValue[0] <= (long)65535L) { 
      dValue[0] = ((double)uiValue[0] - 65536.00) * 0.0625 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4088_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 2047.9375)
    uiValue[0] = (long) ((dValue + 0.00) / 0.0625 + 0.00);
  else if (dValue >= -2047.9375 && dValue <= -0.0625)
    uiValue[0] = (long) ((dValue + 0.00) / 0.0625 + 65536.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4088_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1049L && uiValue[0] <= (long)2047L) { 
      dValue[0] = ((double)uiValue[0] - 2048.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4088_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 99.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= -99.9 && dValue <= -0.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 2048.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4088_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4088_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 1638.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4098_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)94L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 2000.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)95L && uiValue[0] <= (long)99L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 95.00)) * 1) + 1995.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4098_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 2000 && sValue <= 2094)
    uiValue[0] = (long) ((sValue + -2000.00) / 1 - 0.00);
  else if (sValue >= 1995 && sValue <= 1999)
    uiValue[0] = (long) ((sValue + -1995.00) / 1 - -95.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4106_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)4095L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)4097L && uiValue[0] <= (long)8191L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 8192.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4106_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 1 && sValue <= 4095)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -4095 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 8192.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4106_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)0L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1L && uiValue[0] <= (long)4095L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)4097L && uiValue[0] <= (long)8191L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 8192.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4106_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue == 0)
   uiValue[0] = (long) sValue; 
  else if (sValue >= 1 && sValue <= 4095)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -4095 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 8192.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4106_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)1023L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1025L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4106_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 10230)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else if (sValue >= -10230 && sValue <= -10)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4109_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4109_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 99.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4123_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4123_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 99.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4123_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)20L && uiValue[0] <= (long)4000L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 50 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4123_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 1000 && iValue <= 200000)
    uiValue[0] = (long) ((iValue + 0.00) / 50 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4130_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)0L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 1 + 0;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1L && uiValue[0] <= (long)65535L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 1 + 0;
      bIsValid = true;
    } else if (uiValue[0] >= (long)129752L && uiValue[0] <= (long)131071L) { 
      iValue[0] = ((int)uiValue[0] - 131072) * 1 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4130_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue == 0)
   uiValue[0] = (long) iValue; 
  else if (iValue >= 1 && iValue <= 65535)
    uiValue[0] = (long) ((iValue + 0.00) / 1 + 0.00);
  else if (iValue >= -1320 && iValue <= -1)
    uiValue[0] = (long) ((iValue + 0.00) / 1 + 131072.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4130_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)999L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)1949L && uiValue[0] <= (long)2047L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 2048.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4130_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 9990)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else if (sValue >= -990 && sValue <= -10)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 2048.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4130_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)328089L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } else if (uiValue[0] >= (long)1035377L && uiValue[0] <= (long)1048575L) { 
      dValue[0] = ((double)uiValue[0] - 1048576.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4130_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 32808.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else if (dValue >= -1319.9 && dValue <= -0.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 1048576.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4140_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)16383L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4140_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 1638.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4140_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int[] iValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)2047L) { 
      iValue[0] = ((int)uiValue[0] - 0) * 100 + 0;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4140_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, int iValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (iValue >= 0 && iValue <= 204700)
    uiValue[0] = (long) ((iValue + 0.00) / 100 + 0.00);
  else
    uiValue[0] = (long) iValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4142_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)9L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 10) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4142_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 90)
    uiValue[0] = (long) ((sValue + 0.00) / 10 + 0.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4144_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)20L && uiValue[0] <= (long)200L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.01 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4144_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.2 && dValue <= 2)
    uiValue[0] = (long) ((dValue + 0.00) / 0.01 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4144_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)1023L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4144_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 102.3)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4145_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)999999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4145_DISET_2( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 99999.9)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4161_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)127L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4161_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 12.7)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4173_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
      sValue[0] = (short) uiValue[0];
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4173_DISET_5( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4173_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
      sValue[0] = (short) uiValue[0];
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4173_DISET_6( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4192_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)999999999L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.01 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4192_DISET_3( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0 && dValue <= 9999999.99)
    uiValue[0] = (long) ((dValue + 0.00) / 0.01 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4192_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)0L && uiValue[0] <= (long)9999L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] + 0.00)) * 1) + 0.00);
      bIsValid = true;
    } else if (uiValue[0] >= (long)22769L && uiValue[0] <= (long)32767L) { 
      sValue[0] = (short)((short)((((short)(short)uiValue[0] - 32768.00)) * 1) + 0.00);
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4192_DISET_4( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (sValue >= 0 && sValue <= 9999)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 0.00);
  else if (sValue >= -9999 && sValue <= -1)
    uiValue[0] = (long) ((sValue + 0.00) / 1 + 32768.00);
  else
    uiValue[0] = (long) sValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}

static public boolean GET_DFINO_4193_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double[] dValue )
{
  boolean bIsValid = false;

  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if ( GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue ) )
  {
    if (uiValue[0] >= (long)1L && uiValue[0] <= (long)130171L) { 
      dValue[0] = ((double)uiValue[0] + 0.00) * 0.1 + 0.00;
      bIsValid = true;
    } 
  }

  return bIsValid; 
}

static public boolean SET_DFINO_4193_DISET_1( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, double dValue )
{
  long[] uiValue = new long[1];
  uiValue[0] = 0;

  if (dValue >= 0.1 && dValue <= 13017.1)
    uiValue[0] = (long) ((dValue + 0.00) / 0.1 + 0.00);
  else
    uiValue[0] = (long) dValue;

  return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0] );
}


static public boolean GET_DFINO_8001_DISET_7(char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short[] sValue) 
{
    boolean bIsValid = false;
    long[] uiValue = new long[1];
    uiValue[0] = 0;
    if (GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue)) { 
      sValue[0] = (short) uiValue[0];
      bIsValid = true;
    }
  return bIsValid;
}
 
 
static public boolean SET_DFINO_8001_DISET_7(char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, short sValue) 
{
    long[] uiValue = new long[1];
    uiValue[0] = (long) sValue;
    return SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, nBits, uiValue[0]);
}
 
static public boolean CheckBitOverflow( int iNumBitsNeeded, int nBitOffset, int nTotalBits )
{
	boolean overflow = false;

	int iBitsRequired = nBitOffset + iNumBitsNeeded;

	if ( iBitsRequired > nTotalBits )
		overflow = true;

	return( overflow );
}

static public boolean GET_INDICATOR_BIT( char[] pMsg, int[] nBitOffset, int nTotalBits )
{
	boolean valid = false;
	 char byte2Check;

	if ( CheckBitOverflow( 1, nBitOffset[0], nTotalBits ) )
	{
		return( false );
	}

	// Get byte offset into array
	int byteOffset = ( nBitOffset[0] + 1 ) / 8;
	
	// adjust for last bit 
	if ( nBitOffset[0] % 8 == 7 ) 
		byteOffset--;

	byte2Check = pMsg[byteOffset];

	// adjust for 0 index and current position
	int bitNum = nBitOffset[0] + 1;

	// Get bit offset into current byte
	bitNum = bitNum % 8;

	if ( bitNum == 0 )
	{
		bitNum = 8;
	}

	// move GPI/FPI bit to ones position
	byte2Check >>= bitNum - 1;

	if ( (byte2Check & 0x01) != 0 )
	{
		valid = true;
	}

	//increment bit offset
	nBitOffset[0]++;

	return( valid );
}

static public boolean SET_INDICATOR_BIT( char[] pMsg, int[] nBitOffset, int nTotalBits, boolean bIsSet )
{
  if ( CheckBitOverflow( 1, nBitOffset[0], nTotalBits ) )
	{
		return false;
	}

	 char raw;
	if ( bIsSet )
	{
		raw = 0x01;
	}
	else
	{
		raw = 0x00;
	}

	//GET current byte offset into pHdr
	int byteOffset = nBitOffset[0] / 8;

	// GET bit number in current byte
	int currentBitNum = nBitOffset[0] + 1;

	// GET bit offset into current byte
	currentBitNum = currentBitNum % 8;

	if ( currentBitNum == 0 )
	{
		currentBitNum = 8;
	}

	// put bit in correct bit position
	raw <<= ( currentBitNum - 1 );

	// set Gpi, Fpi, or Fri value
	pMsg[byteOffset] |= raw;

	nBitOffset[0]++;

  return true;
}

static public boolean GET_BIT_VALUE( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, long[] nValue )
{
	boolean bIsValid = true;
	nValue[0] = 0;
	long nVal = 0;

	// calls requiring more than 24 bits are handled recursively
	boolean bMoreThan24Bits = false;
	long[] iLeastSignificantValue = new long[1];
	iLeastSignificantValue[0] = 0;

	if ( nBits > 24) 
  {
		bMoreThan24Bits = true;
		if ( !GET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, 24, iLeastSignificantValue ) ) 
    {
			return false;
		}
		nBits = nBits - 24;
	}

	if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
		bIsValid = false;
	}
	else
	{
		// GET byte offset into array
		int byteOffset = ( nBitOffset[0] + 1 ) / 8;

		// adjust for last bit 
		if ( nBitOffset[0] % 8 == 7 ) 
			byteOffset--;
		
		// GET total bytes
		int iTotalBytes = ( nTotalBits + 7 ) / 8;

		// only copy to the end of the buffer
		int iBytesToCopy = 0;
		if ( iTotalBytes - byteOffset < (int) 4 ) {
			iBytesToCopy = iTotalBytes - byteOffset;
			if ( iBytesToCopy < 0 )
				return false;
		}
		else
			iBytesToCopy = 4;

		// worst case, 8th of one byte, need 26 bits 
		long nTemp = 0;
		for (int i = 0; i < iBytesToCopy; i++)
		{
		  nTemp = (0xFF & pMsg[byteOffset + i]);
		  nVal = nVal | (nTemp << i * 8);
		}

		// adjust for 0-based array index and current bit position
		int startingBitNum = nBitOffset[0] + 1;

		// GET bit offset into current byte
		startingBitNum = startingBitNum % 8;

		if ( startingBitNum == 0 )
		{
			startingBitNum = 8;
		}

		// shift rightmost bits off the end
		nVal >>= startingBitNum - 1;

		// clear upper bits
		nVal <<= ( 4 * 8) - nBits;
		nVal = nVal & 0x00000000FFFFFFFFL;

		// realign bits
		nVal >>= ( 4 * 8) - nBits;

		// set new bit offset
		nBitOffset[0] += nBits;
	}

	if ( !bMoreThan24Bits ) 
	{
		nValue[0] = ( long ) nVal;
	}
	else 
	{

		// offset nVal by 24 bits
		nValue[0] = ( ( long )nVal * 0x1000000 ) + iLeastSignificantValue[0];
	}

	return( bIsValid );
}


static public boolean SET_BIT_VALUE( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, long nValue )
{
  boolean bIsValid = true;

	if ( ( nBits > 24 ) && ( nValue >= 0x1000000 ) )
	{
		// GET the lower 24 bits of this value
		long iLeastSignificantValue = 0;
    long iDivQuot = nValue / 0x1000000;
    iLeastSignificantValue = nValue - ( iDivQuot * 0x1000000 );
		bIsValid = SET_BIT_VALUE( pMsg, nBitOffset, nTotalBits, 24, iLeastSignificantValue );
		nBits = nBits - 24;
    nValue = iDivQuot;
	}
	
  if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
		bIsValid = false;
	}

	//GET current byte offset into pHdr
	int byteOffset = nBitOffset[0] / 8;
	int nRaw = (int)nValue;
	char[] rRaw = new char[4];
	for( int i=0; i<4; i++ )
	{
	  rRaw[i] = 0;
	}

	// GET bit number in current byte
	int currentBitNum = nBitOffset[0] + 1;

	// GET bit offset into current byte
	currentBitNum = currentBitNum % 8;

	if ( currentBitNum == 0 )
	{
		currentBitNum = 8;
	}

	// shift value to starting bit position
	nRaw <<= ( currentBitNum - 1 );
	rRaw[3] = (char)((nRaw & 0xFF000000) >> 24);
	rRaw[2] = (char)((nRaw & 0x00FF0000) >> 16);
	rRaw[1] = (char)((nRaw & 0x0000FF00) >> 8);
	rRaw[0] = (char)((nRaw & 0x000000FF));

	// add value to bit stream
	for( int i = 0; i < 4; i++ )
	{
		pMsg[byteOffset++] |= rRaw[i];
	}

	nBitOffset[0] += nBits;

  return bIsValid; 
}

static public boolean SET_ASCII_TEXT( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, String pszText )
{
  if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
		return false;
	}
	
  char raw = 0;
	int nByteOffset = 0;
	int nCurrentBit = 0;
  int nMaxChar = nBits / 7;
	char[] bRaw = new char[2];

  int nChar = pszText.length();
	if ( nChar > nMaxChar )
	{
		nChar = nMaxChar;
	}

	for( int i = 0; i < nChar; i++ )
	{
		//GET current byte offset into pHdr
		nByteOffset = nBitOffset[0] / 8;

		// GET bit number in current byte
		nCurrentBit = nBitOffset[0] + 1;

		// GET bit offset into current byte
		nCurrentBit = nCurrentBit % 8;

		if ( nCurrentBit == 0 )
		{
			nCurrentBit = 8;
		}

		// GET ascii character
		raw = 0;
		raw = pszText.charAt(i);

		// ensure ascii values
		if ( !__isascii( raw ) ) {
			raw = 0x27;
		}

		// shift bits to starting bit position
		raw <<= ( nCurrentBit - 1 );
		bRaw[0] = (char) (raw & 0x00FF);
		bRaw[1] = (char) (raw >> 8);

		// pack bits into header
		pMsg[nByteOffset++] |= bRaw[0];
		pMsg[nByteOffset] |= bRaw[1];

		nBitOffset[0] += 7;
	}

	if ( nChar < nMaxChar )
	{
		nByteOffset = nBitOffset[0] / 8;

		// GET bit number in current byte
		nCurrentBit = nBitOffset[0] + 1;

		// GET bit offset into current byte
		nCurrentBit = nCurrentBit % 8;

		if ( nCurrentBit == 0 )
		{
			nCurrentBit = 8;
		}

		// ASCII delete
		raw = 0x7f;

		// shift bits to starting bit position
		raw <<= ( nCurrentBit - 1 );
		bRaw[0] = (char) (raw & 0x00FF);
		bRaw[1] = (char) (raw >> 8);
		
		// pack bits into header
		pMsg[nByteOffset++] |= bRaw[0];
		pMsg[nByteOffset] |= bRaw[1];

		nBitOffset[0] += 7;
	}

  return true;
}


static public boolean GET_ASCII_TEXT( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, String[] pszText )
{
	boolean bIsValid = true;
	boolean asciiDelete = false;
	char uValue = 0;
	int nMaxChar = nBits / 7;
    int iTotalBytes = nTotalBits / 8;
    char[] szTemp = new char[1000];
    pszText[0] = "";

	if ( nMaxChar > 1000 ) { 
		return false;
   } 

	for( int i = 0; i < nMaxChar && !asciiDelete; i++ )
	{
		// GET byte offset into array
    int byteOffset = nBitOffset[0] / 8;

		// reset 
		uValue = 0;

		if ( CheckBitOverflow( 7, nBitOffset[0], nTotalBits ) )
		{
			bIsValid = false;
      break;
 		}

    char szNextByte = 0; 
    if(byteOffset + 1 < iTotalBytes) { 
      szNextByte = pMsg[byteOffset + 1]; 
     } 
		uValue = (char)(uValue | ((0xFF & pMsg[byteOffset])));
		uValue = (char)(uValue | ((0xFF & szNextByte) << 8));

		// adjust for 0 index and current position
		int startingBitNum = nBitOffset[0] + 1;

		// GET bit offset into current byte
		startingBitNum = startingBitNum % 8;

 		if ( startingBitNum == 0 )
		{
			startingBitNum = 8;
		}

		// shift rightmost bits off the end
		uValue >>= startingBitNum - 1;

		// clear upper nine bits
		uValue <<= 9;

		// realign bits
		uValue >>= 9;

		if ( uValue == 0x7f )
		{
			asciiDelete = true; 
		}
		else if ( __isascii( uValue ) )
		{
			szTemp[i] = ( char ) uValue;
		}
    else
      bIsValid = false;

		// set new bit offset
		nBitOffset[0] += 7;
	}

  if ( bIsValid )
  {
    pszText[0] += new String(szTemp);
    pszText[0] = pszText[0].trim();
  }
  else
  {
    bIsValid = false;
  }

 	return( bIsValid );
}

static public boolean GET_BIT_VALUE_64( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, long[] nValue )
{
  boolean bIsValid = true;
	nValue[0] = 0;
	long nVal = 0;

	if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
		bIsValid = false;
	}
	else
	{
		// GET byte offset into array
		int byteOffset = ( nBitOffset[0] + 1 ) / 8;

		// adjust for last bit 
		if ( nBitOffset[0] % 8 == 7 ) 
			byteOffset--;
		
		// GET total bytes
		int iTotalBytes = ( nTotalBits + 1 ) / 8;
		if ( nTotalBits % 8 == 7 )
			iTotalBytes--;

		// only copy to the end of the buffer
		int iBytesToCopy = 0;
		if ( iTotalBytes - byteOffset < (int) 8 ) {
			iBytesToCopy = iTotalBytes - byteOffset;
			if ( iBytesToCopy < 0 )
				return false;
		}
		else
			iBytesToCopy = 8;

		long nTemp = 0;
		for (int i = 0; i < iBytesToCopy; i++)
		{
		  nTemp = (0xFF & pMsg[byteOffset + i]);
		  nVal = nVal | (nTemp << i * 8);
		}

		// adjust for 0-based array index and current bit position
		int startingBitNum = nBitOffset[0] + 1;

		// GET bit offset into current byte
		startingBitNum = startingBitNum % 8;

		if ( startingBitNum == 0 )
		{
			startingBitNum = 8;
		}

		// shift rightmost bits off the end
		nVal >>>= startingBitNum - 1;

		// clear upper bits
		nVal <<= ( 8 * 8) - nBits;

		// realign bits
		nVal >>>= ( 8 * 8) - nBits;

		// set new bit offset
		nBitOffset[0] += nBits;
	}

  if (bIsValid )
    nValue[0] = nVal;

  return bIsValid;
}

static public boolean SET_BIT_VALUE_64( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, long nValue )
{
  if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
		return false;
	}

	//GET current byte offset into pHdr
	int byteOffset = nBitOffset[0] / 8;
	long nRaw = nValue;
	char[] rRaw = new char[8];

	// GET bit number in current byte
	int currentBitNum = nBitOffset[0] + 1;

	// GET bit offset into current byte
	currentBitNum = currentBitNum % 8;

	if ( currentBitNum == 0 )
	{
		currentBitNum = 8;
	}

	// shift value to starting bit position
	nRaw <<= ( currentBitNum - 1 );
	rRaw[7] = (char)((nRaw & 0xFF000000) >> 56);
	rRaw[6] = (char)((nRaw & 0x00FF0000) >> 48);
	rRaw[5] = (char)((nRaw & 0x0000FF00) >> 40);
	rRaw[4] = (char)((nRaw & 0x000000FF) >> 32);
	rRaw[3] = (char)((nRaw & 0xFF000000) >> 24);
	rRaw[2] = (char)((nRaw & 0x00FF0000) >> 16);
	rRaw[1] = (char)((nRaw & 0x0000FF00) >> 8);
	rRaw[0] = (char)((nRaw & 0x000000FF));

	// add value to bit stream
	for( int i = 0; i < 8; i++ )
	{
		pMsg[byteOffset++] |= rRaw[i];
	}

	nBitOffset[0] += nBits;

  return true;
}

static public boolean GET_BYTE_VALUE( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, char[] pszValue, int iSizeBytes )
{
	boolean bIsValid = true;

  int nBytes = nBits/8;

  //char szTemp[nBytes] = {0};

	if ( iSizeBytes < nBytes )
		return false;

	for( int i = 0; i < nBytes; i++ )
	{
		// GET byte offset into array
    int byteOffset = nBitOffset[0] / 8;

		 short usValue = 0;

		if ( CheckBitOverflow( 8, nBitOffset[0], nTotalBits ) )
		{
			bIsValid = false;
      break;
 		}

		usValue = (short)(usValue | ((0xFF & pMsg[byteOffset])));
		usValue = (short)(usValue | ((0xFF & pMsg[byteOffset + 1]) << 8));

		// adjust for 0 index and current position
		int startingBitNum = nBitOffset[0] + 1;

		// GET bit offset into current byte
		startingBitNum = startingBitNum % 8;

 		if ( startingBitNum == 0 )
		{
			startingBitNum = 8;
		}

		// shift rightmost bits off the end
		usValue >>= startingBitNum - 1;

		// clear upper nine bits
		usValue <<= 9;

		// realign bits
		usValue >>= 9;

    // add to temp array
    pszValue[i] = (char) usValue;

		// set new bit offset
		nBitOffset[0] += 8;
	}

  //if ( bIsValid )
  //{
  //  memcpy( pszValue, szTemp, nBytes );
  //}

 	return bIsValid; 
}

static public boolean SET_BYTE_VALUE( char[] pMsg, int[] nBitOffset, int nTotalBits, int nBits, char[] pszValue, int iSizeBytes )
{
  if ( CheckBitOverflow( nBits, nBitOffset[0], nTotalBits ) )
	{
    return false;
	}

  int iBytes = nBits / 8;

  if ( (pszValue != null) && (iSizeBytes >= iBytes) )
  {

    for( int i = 0; i < iBytes; i++ )
	  {
		  //GET current byte offset
		  int nByteOffset = nBitOffset[0] / 8;

		  // GET bit number in current byte
		  int nCurrentBit = nBitOffset[0] + 1;

		  // GET bit offset into current byte
		  nCurrentBit = nCurrentBit % 8;

		  if ( nCurrentBit == 0 )
		  {
			  nCurrentBit = 8;
		  }

		  // GET ascii character
		   short raw = 0;
		  raw = (short) pszValue[i];

		  // shift bits to starting bit position
		  raw <<= ( nCurrentBit - 1 );

        char[] bRaw = new char[2];
        bRaw[0] = (char) (raw & 0x00FF);
        bRaw[1] = (char) (raw >> 8);

      // pack bits into pMsg
		  pMsg[nByteOffset++] |= bRaw[0];
		  pMsg[nByteOffset] |= bRaw[1];

		  nBitOffset[0] += 8;
	  }
  
  }
  
  return true;
}

};

