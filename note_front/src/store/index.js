import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state:{
    currentUser: window.localStorage.getItem('user') === null?'':JSON.parse(window.localStorage.getItem('user'))
  },
  mutations:{
    saveUser(state,user){
      state.currentUser = user;
      window.localStorage.setItem("user",JSON.stringify(user))
    },
    addmu(state){state.count++},
    lessmu(state){state.count--}
  }
})

 export default store
