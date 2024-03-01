<template>
  <div id="app" >
    <HmHeader v-if="$route.meta.alive"></HmHeader>
    <router-view></router-view>
  </div>
</template>

<script>
import HmHeader from './components/HmHeader.vue'
// import Bus from '@/utils/EventBus'

export default {
  name: 'App',
  components: {
    HmHeader

  },provide(){
        return{
            
        }
    },data(){
    return{
      header_show:true
    }
  },created(){
    
  },methods:{
    // sxb(){
    //       this.reload()
    //   },
   
   
  },mounted(){
    this.render()
    
  }
      
  
}
</script>

<style >
a{
  text-decoration: none;
}
</style>
