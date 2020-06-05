<template>
  <el-row class="container">
    <!-- 头部-->
    <el-col :span="24" class="topbar-wrap">

      <div class="topbar-logo topbar-btn">
        <img src="../../assets/logo.png" style="padding-left:8px;">
      </div>
      <div class="topbar-logos">
        <!-- <span>在线云笔记</span> -->
        <label style="color: #fff;">在线云笔记</label>
      </div>
      <div class="topbar-title">
        <el-menu  class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        text-color="#fff"
        active-text-color="#ffd04b"
        router
        :default-active="'/home'">
          <el-menu-item v-for="(item,i) in naviList" :index="item.url" :key="i">
            {{ item.name}}
          </el-menu-item>
        </el-menu>
      </div>
         <div class="topbar-account topbar-btn">
              <el-dropdown trigger="click">
                <span class="el-dropdown-link userinfo-inner">
                  <i class="iconfont icon-user"></i>  <i class="el-icon-caret-bottom"></i></span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>
                    <div @click="jumpTo('/user/profile')"><span style="color: #555;font-size: 14px;">个人信息</span></div>
                  </el-dropdown-item>
                  <el-dropdown-item>
                    <div @click="jumpTo('/user/changepwd')"><span style="color: #555;font-size: 14px;">修改密码</span></div>
                  </el-dropdown-item>
                  <el-dropdown-item divided @click.native="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
    </el-col>
  </el-row>
</template>

<script>
  import 'element-ui/lib/theme-chalk/display.css';
  export default {
    name: "NavMenu",
    data() {
      return {
        naviList: [
          {name: "首页", url: '/home'},
          {name: "书架", url: '/booksheef'},
        ]
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>

<style>
  @import url("../../assets/css/style.css");

  .navibar {
    width: 100%;
    top: 0px;
    left: 0px;
  }

  /* .el-menu-item{
    //font-weight: bolder !important;
  }
  .el-menu--horizontal>.el-menu-item {
     height: 35px!important;
     line-height: 35px!important;
   }
   .el-menu--horizontal>.el-submenu .el-submenu__title {
     height: 35px!important;
     line-height: 35px!important;
   } */
</style>
