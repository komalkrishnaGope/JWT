import React, {useState} from 'react';
import {View, Text, Image,ScrollView} from 'react-native';
import {Card} from 'react-native-paper';
import {
  Flex,
  TextInput,
  Backdrop,
  BackdropSubheader,
  AppBar,
  Button,
} from '@react-native-material/core';
import SelectDropdown from 'react-native-select-dropdown';

export default function Tax() {
  const login = ['Employee Login','IRS Officers Online', 'Official Email Systems'];
  const ass_year= ['Select','2021-2022','2022-2023'];
  return (
    <ScrollView>
      <View
        style={{flexDirection: 'row', backgroundColor: 'white', height: 90}}>
        <Image
          style={{width: 70, height: 70, marginTop: 6}}
          source={require('./../assets/tax.png')}
        />
        <View style={{marginLeft: 20}}>
          <Text style={{fontSize: 20, fontWeight: 'bold', marginTop: '12%'}}>
            Income Tax Department
          </Text>
          <Text style={{fontWeight: 'bold'}}>Governtment of India</Text>
        </View>
      </View>
      <View style={{height: 50, backgroundColor: 'grey'}}>
        <SelectDropdown
          defaultValue={'Employee Login'}
          buttonStyle={{width: '45%'}}
          data={login}
         
        />
         </View>
        <View style={{height: 50, backgroundColor: '#eff3f7',flexDirection:"row"}}>
          <Text style={{marginTop:15,fontSize:17,marginLeft:"25%"}}>Income and Tax Calculator</Text>
          </View>


<Card style={{height: 50, backgroundColor: '#eff3f7',marginTop:30,width:300,marginLeft:60,borderRadius:0}}>
<Text style={{fontSize:17,color:"black",marginLeft:10,marginTop:10}}>(As amended upto Finance Act,2022)</Text>
</Card>
<View style={{backgroundColor:"#3b9ac6",height:50,width:260,marginTop:10,marginLeft:60}}>
<Text style={{color:"white",fontSize:17,marginTop:12,marginLeft:5,fontWeight:400}}>INCOME AND TAX CALCULATOR</Text>
</View>
          <Text style={{marginLeft:"30%",marginTop:20,fontSize:15}}>Click here to view relevant Act & Rule</Text>
    

    <Card style={{marginTop:20,borderRadius:0,width:360,marginLeft:15}}>
        <View style={{height:100}}>
            <Text style={{fontSize:17,color:"black",marginLeft:10,marginTop:10}}>Assesment Year</Text>
           <Card  style={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10}}>
            <SelectDropdown
          
          defaultValue={'Select'}
          buttonStyle={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10,height:40}}
          data={ass_year}
         
        />
        </Card>
        </View>
        <View style={{height:100,backgroundColor:"white"}}>
            <Text style={{fontSize:17,color:"black",marginLeft:10,marginTop:10}}>Tax Payer</Text>
           <Card style={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10}}>
            <SelectDropdown
          
          defaultValue={'Select'}
          buttonStyle={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10,height:40}}
          data={ass_year}
         
        />
        </Card>
        </View>
        <View style={{height:100}}>
            <Text style={{fontSize:17,color:"black",marginLeft:10,marginTop:10}}>Male/Female/Senior Citizen</Text>
           <Card  style={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10}}>
            <SelectDropdown
          
          defaultValue={'Select'}
          buttonStyle={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10,height:40}}
          data={ass_year}
         
        />
        </Card>
        </View>
        <View style={{height:100,backgroundColor:"white"}}>
            <Text style={{fontSize:17,color:"black",marginLeft:10,marginTop:10}}>Resdential Status</Text>
           <Card style={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10}}>
            <SelectDropdown
          
          defaultValue={'Select'}
          buttonStyle={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10,height:40}}
          data={ass_year}
         
        />
        </Card>
        </View>
    </Card>
    </ScrollView>
  );
}
