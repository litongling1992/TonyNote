<template>
  <div class="navibar">
    <el-menu  class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    text-color="#fff"
    background-color="#363738"
    active-text-color="#ffd04b"
    router
    :default-active="'/home'">
      <el-menu-item v-for="(item,i) in naviList" :index="item.url" :key="i">
        {{ item.name}}
      </el-menu-item>
    </el-menu>
     <el-submenu index="2" style="float:right;">
           <i>hhhhh</i>
     </el-submenu>
  </div>



 <!-- <el-row class="container"> -->
    <!-- 头部-->
   <!-- <el-col :span="24" class="topbar-wrap"> -->
      <!-- <div class="topbar-logo topbar-btn">
        <img src="../../assets/logo.png" style="padding-left:8px;">
      </div>
      <div class="topbar-logos">
        <label style="color: #fff;">在线云笔记</label>
      </div> -->

      <!-- <div class="topbar-title">
        <el-menu  class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        text-color="#000"
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
    </el-col> -->
  <!-- </el-row> -->

</template>

<script>
  import 'element-ui/lib/theme-chalk/display.css';
  export default {
    name: "NavMenu",
    data() {
      return {
         isLogin:'none',
                  userFlag: {
                    name: '',
                    menuList: []
                  },
        naviList: [{
            name: "首页",
            url: '/home'
          },
          {
            name: "书架",
            url: '/booksheef'
          },
        ]
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
  // <script>
  // export default {
  //   name: "TopNaviBar",
  //   data() {
  //     return {};
  //   },
  //   methods: {
  //     openTest() {
  //       this.$confirm("确认退出？")
  //         .then(_ => {
  //           done();
  //         })
  //         .catch(_ => {});
  //     }
  //   }
  // };
  //<script>
</script>

<style>
  /* @import url("../../assets/css/style.css");

  .navibar {
    width: 100%;
    top: 0px;
    left: 0px;
  } */

 .maincontainer {
    float: left;
    width: 100%;
    height: 50px;
    margin-top: 0;
    position: fixed;
  }
  .left {
    background: #333744;
    width: 190px;
    height: 50px;
    float: left;
    left: 0;
  }

  .right {
    background: #2C3E50;
    width: 88px;
    height: 50px;
    float: right;
  }

  /* 中间菜单的div可操作 */
  .center {
    background: #00C1DE;
    width: calc(100% - 300px);
    height: 50px;
    color: #fff;
    float: left;
    position: relative;
  }

  .navibar {
    background-color: #363738;
    width: 100%;
    top: 0px;
    left: 0px;
  }

  .el-menu-item {
    font-weight: bolder !important;
  }

  .el-menu--horizontal>.el-menu-item {
    height: 35px !important;
    line-height: 35px !important;
  }

  .el-menu--horizontal>.el-submenu .el-submenu__title {
    height: 35px !important;
    line-height: 35px !important;
  }
</style>
