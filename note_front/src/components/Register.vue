<template>
  <body>
    <div>
      <el-form :model="registerForm" label-width="0px" class="login-container" label-position="left">
        <h3 class="login_title">注册</h3>
        <div>{{registerForm.states}}</div>
        <el-form-item prop="name">
          <el-input placeholder="请输入用户名" v-model="registerForm.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input placeholder="请输入密码" v-model="registerForm.password" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-input placeholder="请再输入密码" v-model="registerForm.passwordagain" show-password></el-input>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 100%;background: #505458;border: none" @click="onSubmit">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </body>

</template>

<script>
  export default {
    name: "Register",
    data() {
      return {
        registerForm: {
          username: '',
          password: '',
          passwordagain: '',
          states: '',
        }
      }
    },
    methods: {
      onSubmit() {
        let that = this;
        // post 数据度知
        let postData = {
          username: this.registerForm.username,
          password: this.registerForm.password,
          passwordagain: this.registerForm.passwordagain,
        }
        if(postData.username==''|| postData.password == '' || postData.passwordagain == ''){
          this.$message({
            message: '账户名或者密码不允许为空',
            type: 'error'
          });
          return;
        }
        if (postData.password != postData.passwordagain ) {
          this.$message({
            message: '两次输入的密码不一致',
            type: 'error'
          });
          return;
        }
        this.axios.post('/register', postData)
          .then(function(respone) {
            console.log(respone)
            that.registerForm.states = respone.data;
            that.$router.replace('/login');
          })
          .catch(function(error) {
            console.log(error)
          })
      },
    }
  }
</script>

<style>
  body {
    background-color: skyblue;
    color: #AAAAAA;
  }

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

  #poster {
    background: url("../assets/logo.png") no-repeat;
    background-position: center;
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
</style>
