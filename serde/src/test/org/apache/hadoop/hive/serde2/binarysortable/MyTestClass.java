/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hive.serde2.binarysortable;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.hadoop.hive.common.type.HiveChar;
import org.apache.hadoop.hive.common.type.HiveDecimal;
import org.apache.hadoop.hive.common.type.HiveIntervalDayTime;
import org.apache.hadoop.hive.common.type.HiveIntervalYearMonth;
import org.apache.hadoop.hive.common.type.HiveVarchar;
import org.apache.hadoop.hive.serde2.binarysortable.MyTestPrimitiveClass.ExtraTypeInfo;

public class MyTestClass {

    public Boolean myBool;
    public Byte myByte;
    public Short myShort;
    public Integer myInt;
    public Long myLong;
    public Float myFloat;
    public Double myDouble;
    public String myString;
    public HiveChar myHiveChar;
    public HiveVarchar myHiveVarchar;
    public byte[] myBinary;
    public HiveDecimal myDecimal;
    public Date myDate;
    public Timestamp myTimestamp;
    public HiveIntervalYearMonth myIntervalYearMonth;
    public HiveIntervalDayTime myIntervalDayTime;

    // Add more complex types.
    public MyTestInnerStruct myStruct;
    public  List<Integer> myList;

    public MyTestClass() {
    }

    public final static int fieldCount = 18;

    public int randomFill(Random r, ExtraTypeInfo extraTypeInfo) {
      int randField = r.nextInt(MyTestClass.fieldCount);
      int field = 0;

      myBool = (randField == field++) ? null : (r.nextInt(1) == 1);
      myByte = (randField == field++) ? null : Byte.valueOf((byte) r.nextInt());
      myShort = (randField == field++) ? null : Short.valueOf((short) r.nextInt());
      myInt = (randField == field++) ? null : Integer.valueOf(r.nextInt());
      myLong = (randField == field++) ? null : Long.valueOf(r.nextLong());
      myFloat = (randField == field++) ? null : Float
          .valueOf(r.nextFloat() * 10 - 5);
      myDouble = (randField == field++) ? null : Double
          .valueOf(r.nextDouble() * 10 - 5);
      myString = (randField == field++) ? null : MyTestPrimitiveClass.getRandString(r);
      myHiveChar = (randField == field++) ? null : MyTestPrimitiveClass.getRandHiveChar(r, extraTypeInfo);
      myHiveVarchar = (randField == field++) ? null : MyTestPrimitiveClass.getRandHiveVarchar(r, extraTypeInfo);
      myBinary = MyTestPrimitiveClass.getRandBinary(r, r.nextInt(1000));
      myDecimal = (randField == field++) ? null : MyTestPrimitiveClass.getRandHiveDecimal(r, extraTypeInfo);
      myDate = (randField == field++) ? null : MyTestPrimitiveClass.getRandDate(r);
      myTimestamp = (randField == field++) ? null : MyTestPrimitiveClass.getRandTimestamp(r);
      myIntervalYearMonth = (randField == field++) ? null : MyTestPrimitiveClass.getRandIntervalYearMonth(r);
      myIntervalDayTime = (randField == field++) ? null : MyTestPrimitiveClass.getRandIntervalDayTime(r);

      myStruct = (randField == field++) ? null : new MyTestInnerStruct(
          r.nextInt(5) - 2, r.nextInt(5) - 2);
      myList = (randField == field++) ? null : getRandIntegerArray(r);
      return field;
    }

    public static List<Integer> getRandIntegerArray(Random r) {
      int length = r.nextInt(10);
      ArrayList<Integer> result = new ArrayList<Integer>(length);
      for (int i = 0; i < length; i++) {
        result.add(r.nextInt(128));
      }
      return result;
    }

}
