import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home'
import Login from '../views/Login'
import About from '../views/About'
import Register from '../views/Register'
import Store from '../views/Store'
import Member from '../views/Member'
import Information from '../views/Information'
import Chart from '../views/Chart'
import OrderList from '../views/OrderList'
import CheckOut from '../views/CheckOut'
import CheckOutPage from '../views/CheckOutPage'
import OrderProductList from '../views/OrderProductList'

Vue.use(VueRouter) //插件初始化
const router = new VueRouter({
    routes:[
        { path: '/home',component: Home,meta:{
            alive:true
        }},
        { path: '/login',component: Login,meta:{
            alive:true
        }},
        { path: '/about',component: About,meta:{
            alive:true
        }},
        { path: '/register',component: Register,meta:{
            alive:true
        }},
        { path: '/store',component: Store,
        meta:{
            alive:true
        }
        },
        { path: '/checkout',component: CheckOut,        
            meta:{
                alive:false
            }
        },
        { path: '/checkoutpage',component: CheckOutPage,        
            meta:{
                alive:false
            }
        },
        { 
            path: '/member',component: Member,
            meta:{
                alive:true
            },
            children:[
                {       path:'/information',
                        component:Information,
                        meta:{
                            alive:true
                        }, },
                {       path:'/chart',
                        component:Chart,
                        meta:{
                            alive:true
                        }, },
                {       path:'/orderlist',
                        component:OrderList,
                        meta:{
                            alive:true
                        }, },
                {       path:'/orderProductlist',
                        component:OrderProductList,
                        meta:{
                            alive:true
                        }, },
            ]
        }
    ]
}) //空路由對象

export default router


