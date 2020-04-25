<template>
  <body id="poster">
  <el-form class="login-container" label-position="left"
           label-width="0px">
    <h3 class="login_title">系统登录</h3>
    <el-form-item>
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item>
      <el-input type="password" v-model="loginForm.password"
                auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
    </el-form-item>
  </el-form>
  </body>
</template>

<script>
  export default{
    name: "Login",
    data(){
      return {
        loginForm: {
          username: '',
          password: '',
          states: '',
        },
        responseResult: []
      }
    },
    methods:{
       login(){
         let that = this ;
         let postData={
           username: this.loginForm.username,
           password: this.loginForm.password,
         }
         this.axios.post('/login',postData)
         .then(function (respone){
            //console.log(respone.data);
           console.log(respone.data.status);
           if(respone.data.status == 200){

             that.loginForm.states = respone.data.msg;
             console.log(respone.data.msg);
             that.$store.commit(types.ADD_BIAOTI,respone.data.object);
              that.$router.push('/');
           }else{
             alert("账号或密码错误...")
           }


         })
         .catch(function(error){
           console.log(error);
           that.loginForm.states = respone.data.msg;
         })
       }
    }
  }
</script>

<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  #poster{
    background: url("../assets/logo.png") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
</style>
