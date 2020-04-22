<template>
  <div>
    <el-form :model="registerForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item prop="name">
        <el-input placeholder="请输入用户名" v-model="registerForm.name"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input placeholder="请输入密码" v-model="registerForm.password" show-password></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit" >立即创建</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default{
    name:"Register",
    data(){
      return{
        registerForm:{
          username:'',
          password:'',
        }
      }
    },
    methods:{
      onSubmit(){
      }
    }
  }
</script>

<style>
</style>
