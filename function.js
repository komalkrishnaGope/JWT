import React, {useState} from 'react';
import {View, Text, Image, ScrollView} from 'react-native';
import {Card} from 'react-native-paper';
import SelectDropdown from 'react-native-select-dropdown';
import Support from './support';
import { Dropdown } from 'react-native-element-dropdown';
export default function Funct() {
  const login = [
    'Employee Login',
    'IRS Officers Online',
    'Official Email Systems',
  ];
  const tax = ['Select', 'yes', 'no'];
  
  return (
    <ScrollView>
     
    
   
        <View >
          <Text
            style={{
              fontSize: 17,
              color: 'black',
              marginLeft: 10,
              marginTop: 10,
            }}>
           Whether opting for taxation under Section 115BAC?
          </Text>
          <Card
            style={{
              width: '85%',
              backgroundColor: 'white',
              marginTop: 10,
              left: 10,
              borderRadius: 10,
            }}>
           

            <SelectDropdown
              buttonStyle={{
                width: '85%',
                backgroundColor: 'white',
                marginTop: 10,
                left: 10,
                borderRadius: 10,
                height: 40,
              }}
              data={tax}
              labelField="label"
            />
          </Card>

        
        </View>
     
       

    </ScrollView>
  );
}
