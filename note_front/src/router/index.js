import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Register from '@/components/Register'
import Login from '@/components/Login'
import Index from '@/components/Index'
import BookSheef from '@/components/booksheef/BookSheef.vue'
import CategoryBar from '@/components/booksheef/CategoryBar.vue'
import Notes from '@/components/booksheef/notes.vue'

//import Index from'@/components/common/NavMenu'
//import NavMenu from "./common/NavMenu";

Vue.use(Router)

import Home from '@/components/home/Home.vue'

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/',
      name: 'Index',
      component: Index,
      redirect: '/home',
      children: [
        {
          path: '/home',
          name: 'Home',
          component: Home
        },
        {
          path: '/booksheef',
          name: 'BookSheef',
          component: BookSheef
        },
      ]
    },



  ]
})
