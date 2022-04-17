import React, { Component, useState } from 'react';
import {View, Text, TextInput, TouchableOpacity, StatusBar} from 'react-native';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      Masukkannilaiinput:0,
      hasilinputa:0,
      hasilinputb:0,
    };
  }

  hitungcicilan = ()=>{
    
    let dp = parseFloat(this.state.Masukkannilaiinput) * 0.3;
    let plafonpinjaman = parseFloat(this.state.Masukkannilaiinput) - dp;
    let angsuranpokok = parseFloat(plafonpinjaman / 60); 
    let angsuranbunga = parseFloat((plafonpinjaman * 0.048) / 12);
    let cicilanperbulan = parseFloat(angsuranpokok + angsuranbunga);
      this.setState({hasilinputb:cicilanperbulan});

    let biayasuransi = parseFloat(this.state.Masukkannilaiinput) * 0.05;
    let biayaprovinsi = parseFloat(plafonpinjaman * 0.005);
    let polisasuransi = 40000;
    let biayadmin = 700000;
    let pembayaranpertama = (dp + cicilanperbulan + biayasuransi + biayaprovinsi + polisasuransi + biayadmin);
      this.setState({hasilinputa:pembayaranpertama});
    
    
  }

  render() {
    return (

      <View style={{flex:1}}>
        <View style={{
          flext:1,
          justifyContent:'center',
          alignItems:'center',
          elevation:5,
          backgroundColor:'#283747',
        }}>

          <Text style={{color:'#ffffff', fontWeight:'bold', fontSize:16}}>Project UAS Alfian</Text>
      </View>

      <View style={{
        flex:8,
        justifyContent:'center',
        alignItems:'center',
        elevation:5,
        backgroundColor:'#FFFFFF',
      }}>

        <Text>Masukkan Jumlah Uang</Text>

        <TextInput
          value={String(this.state.Masukkannilaiinput)}
          style={{
            marginHorizontal:20,
            marginTop:10,
            paddingVertical:10,
            paddingHorizontal:15,
            backgroundColor:'#283747',
            color:'#fff',
            borderRadius:10
          }}
          keyboardType='number-pad'
          onChangeText={(value) => this.setState({Masukkannilaiinput:value})}
          />
          

           <TouchableOpacity
              onPress={()=> this.hitungcicilan()}
              style={{
                backgroundColor:'#283747',
                marginTop:30,
                marginHorizontal:50,
                paddingHorizontal:15,
                paddingVertical:20,
                borderRadius:10
              }}>
                <Text style={{color:'#fff', textAlign:'center',fontWeight:'bold'}}>Hitung Jumlah Uang Kredit</Text>
              </TouchableOpacity>

              <View style={{
                marginHorizontal:50,
                marginTop:30,
                justifyContent:'center',
                alignContent:'center',
                paddingVertical:50
              }}>
                <Text>Pembayaran Angsuran Pertama</Text>
                <Text   style={{color:'#283747',fontSize:55}}>{this.state.hasilinputa}</Text>
                <Text>Biaya Kredit Perbulan belaku selama 5 Tahun</Text>
                <Text style={{color:'#283747',fontSize:55}}>{this.state.hasilinputb}</Text>
              </View>

        </View>

      </View>      
    );
  }
}

export default App;

