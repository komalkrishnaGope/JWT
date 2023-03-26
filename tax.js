import React, {useState} from 'react';
import {View, Text, Image, ScrollView,TouchableOpacity} from 'react-native';
import {Card} from 'react-native-paper';
import SelectDropdown from 'react-native-select-dropdown';
import Support from './support';
import {Dropdown} from 'react-native-element-dropdown';
import Funct from './function';
import Icon from 'react-native-vector-icons/MaterialCommunityIcons';

export default function Tax() {

  const [showMenu, setShowMenu] = useState(false);

  const toggleMenu = () => {
    setShowMenu(!showMenu);
  };
  const login = ['IRS Officers Online', 'Official Email Systems'];
  const ass_year = ['Select', '2021-2022', '2022-2023'];
  // const [value, setValue] = useState(null);
  const [flag, setFlag] = useState(false);
  const [selectedMonth, setSelectedMonth] = useState('');
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
      <View style={{height: 50, backgroundColor: '#ececec'}}>
        <View style={{flexDirection: 'row'}}>
          <SelectDropdown
            defaultButtonText={'Employee Login'}
            // defaultValue={'Employee Login'}
            buttonStyle={{width: '45%',backgroundColor:"#ececec"}}
            data={login}
          />

<View style={{ flexDirection: 'row',alignItems: 'center',}}>
      <TouchableOpacity onPress={toggleMenu} style={{marginLeft:170}}>
        <Icon name="menu" size={30} color="black"   />
      </TouchableOpacity>
      {showMenu && (
        <View style={{position: 'absolute',
        top: 40,
        right: 10,
        backgroundColor: '#fff',
        padding: 20,
        borderRadius: 5,
        elevation: 5}}>
          <Text>About Us</Text>
          <Text>Tax Payers Charter</Text>
          <Text>Downloads</Text>
        </View>
)
}

</View>
        </View>
      </View>
      <View
        style={{height: 50, backgroundColor: '#eff3f7', flexDirection: 'row',zIndex:-10}}>
        <Text style={{marginTop: 15, fontSize: 17, marginLeft: '25%'}}>
          Income and Tax Calculator
        </Text>
      </View>

      <Card
        style={{
          height: 50,
          backgroundColor: '#eff3f7',
          marginTop: 30,
          width: 300,
          marginLeft: 60,
          borderRadius: 0,
        }}>
        <Text
          style={{fontSize: 17, color: 'black', marginLeft: 10, marginTop: 10}}>
          (As amended upto Finance Act,2022)
        </Text>
      </Card>
      <View
        style={{
          backgroundColor: '#3b9ac6',
          height: 50,
          width: 260,
          marginTop: 10,
          marginLeft: 60,
        }}>
        <Text
          style={{
            color: 'white',
            fontSize: 17,
            marginTop: 12,
            marginLeft: 5,
            fontWeight: 400,
          }}>
          INCOME AND TAX CALCULATOR
        </Text>
      </View>
      <Text style={{marginLeft: '30%', marginTop: 20, fontSize: 15}}>
        Click here to view relevant Act & Rule
      </Text>

      <Card
        style={{marginTop: 20, borderRadius: 0, width: 360, marginLeft: 15}}>
        <View style={{height: 100}}>
          <Text
            style={{
              fontSize: 17,
              color: 'black',
              marginLeft: 10,
              marginTop: 10,
            }}>
            Assesment Year
          </Text>
          <Card
            style={{
              width: '85%',
              backgroundColor: 'white',
              marginTop: 10,
              left: 10,
              borderRadius: 10,
            }}>
            {/* <SelectDropdown
          
          defaultValue={'Select'}
          buttonStyle={{width: '85%',backgroundColor:"white",marginTop:10,left:10,borderRadius:10,height:40}}
          data={ass_year}
          value={value}
          onChange={item => {
            setValue(item.value);
            setIsFocus(false);
            setMonth(item.value);
            setFlag(true);
        }}
        /> */}

            <SelectDropdown
              buttonStyle={{
                width: '85%',
                backgroundColor: 'white',
                marginTop: 10,
                left: 10,
                borderRadius: 10,
                height: 40,
              }}
              data={ass_year}
              labelField="label"
              value={selectedMonth}
              onSelect={item => {
        
                setSelectedMonth(item.value);
                setFlag(true);
              }}
            />
          </Card>
        </View>
        <View style={{backgroundColor: 'white'}}>
          <Text
            style={{
              fontSize: 17,
              color: 'black',
              marginLeft: 10,
              marginTop: 10,
            }}>
            Tax Payer
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
              defaultValue={'Select'}
              buttonStyle={{
                width: '85%',
                backgroundColor: 'white',
                marginTop: 10,
                left: 10,
                borderRadius: 10,
                height: 40,
              }}
              data={login}
            />
          </Card>

          {flag ? <Funct /> : ''}
        </View>
        <View style={{height: 100}}>
          <Text
            style={{
              fontSize: 17,
              color: 'black',
              marginLeft: 10,
              marginTop: 10,
            }}>
            Male/Female/Senior Citizen
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
              defaultValue={'Select'}
              buttonStyle={{
                width: '85%',
                backgroundColor: 'white',
                marginTop: 10,
                left: 10,
                borderRadius: 10,
                height: 40,
              }}
              data={login}
            />
          </Card>
        </View>
        <View style={{height: 100, backgroundColor: 'white'}}>
          <Text
            style={{
              fontSize: 17,
              color: 'black',
              marginLeft: 10,
              marginTop: 10,
            }}>
            Resdential Status
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
              defaultValue={'Select'}
              buttonStyle={{
                width: '85%',
                backgroundColor: 'white',
                marginTop: 10,
                left: 10,
                borderRadius: 10,
                height: 40,
              }}
              data={login}
            />
          </Card>
        </View>
      </Card>
    </ScrollView>
  );
}
