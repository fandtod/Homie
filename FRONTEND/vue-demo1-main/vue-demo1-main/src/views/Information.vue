<template>
  <div>
        <table>
            <ul >
                
                <div class="distance">
                    <label for="name">姓名 </label>
                    <input v-model="userInfo.userName" type="text" id="name">
                </div>
                <div class="distance">
                        <label for="bir">垃圾幣 </label>
                        <input v-model="userInfo.garbageCoin" type="text" id="bir" disabled>
                </div>
                <div class="distance">
                        <label for="phone">電話 </label>
                        <input v-model="userInfo.userPhone" type="text" id="phone">
                </div>
                <div class="distance">
                    <label for="add">地址 </label>
                    <input v-model="userInfo.userAddress" type="text" id="add">
                </div>
                <div class="distance">
                    <label for="ic">身份證</label>
                <input v-model="userInfo.userIc" type="text" id="ic">
                </div>
            </ul>
        </table>
    

        
        <button class="sub" @click="changeInfo"  @keyup.enter="changeInfo">修改個人資料</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
name:'InformationPage',
    data(){
        return{
            userId:1,
            userInfo:{
                userName:"",
                garbageCoin:"",
                userPhone:"",
                userAddress:"",
                userIc:""
            }
            
        }
    },created(){
        const uid = localStorage.getItem('uid')
        this.userId=uid
        
    },methods:{
        getAll(){
            axios.get(`http://localhost:8005/homie-demo/userall/${this.userId}`).then(res=>{
            this.userInfo.userName=res.data[0].userName
            this.userInfo.garbageCoin=res.data[0].garbageCoin
            this.userInfo.userPhone=res.data[0].userPhone
            this.userInfo.userAddress=res.data[0].userAddress
            this.userInfo.userIc=res.data[0].userIc
        })
        },
        changeInfo(){
            axios.put(`http://localhost:8005/homie-demo/information/${this.userId}`,this.userInfo).then(res=>{
            console.log(res)
        })
        }
    },mounted(){
        this.getAll()
    }
}
</script>

<style scoped>
input{
    padding: 2px 5px;
}
label{
    display: flex;       
  height: 300px;
  align-items: center; 
    position: absolute;
    left: 200px;
    
}

.distance{
    padding: 5px;
    padding-bottom: 15px;
    display: flex;
    justify-content: center;    
    align-items: center;  
    margin-left:220px ;
}
.sub{
    position: relative;
    left: -20px;
    width: 120px;
    height: 30px;
    background-color: #a4a4a4;
    border:1px solid #ffffff;
    margin:0 15px ;
    margin-top: 50px;
    cursor: pointer;
    color: #ededed;
    border-radius: 5%;
    margin-left: 25px;
}
.sub:hover{
    background-color: #1085bc;;
}
</style>