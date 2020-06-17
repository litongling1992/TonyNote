<template>
<el-container>
 <!-- <el-header>Header</el-header>
  <el-container>
    <el-aside width="200px">Aside</el-aside>
    <el-main>

    </el-main>
  </el-container> -->
  <div class="container float">
      <div class="left">
        <el-tooltip content="Top center" placement="top">
          <el-button>Dark</el-button>
        </el-tooltip>
      </div>
      <div class="right"> 右</div>
      <div class="center">方法一：float法</div>
  </div>

  <div class="container position">
      <div class="left"></div>
      <div class="center">方法二：position法</div>
      <div class="right"></div>
  </div>

  <div class="container flex">
      <div class="left"></div>
      <div class="center">方法三：flex法</div>
      <div class="right"></div>
  </div>
  <div class="container table">
      <div class="left inner"></div>
      <div class="center inner">方法四：table法</div>
      <div class="right inner"></div>
  </div>

</el-container>
</template>

<script>
  export default {
    name: 'PageTest',
    data() {
      return {

      };
    }
  }
</script>

<style>
  .el-header, .el-footer {
      background-color: #B3C0D1;
      color: #333;
      text-align: center;
      line-height: 60px;
    }

    .el-aside {
      background-color: #D3DCE6;
      color: #333;
      text-align: center;
      line-height: 200px;
    }

    .el-main {
      background-color: #E9EEF3;
      color: #333;
      text-align: center;
      line-height: 160px;
    }

    body > .el-container {
      margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
      line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
      line-height: 320px;
    }

    .container{
                width:500px;
                height:200px;
                margin: 10px auto;
            }
            .left,
            .right{
                width: 100px;
                height: 100%;
                background-color: antiquewhite;
            }

            .center{
                background-color: aquamarine;
            }

            /*方法一：float*/
            .float .left{
                float: left;
            }
            .float .right{
                float: right;
            }
            .float .center{
                height: 100%;
                margin: 0px 100px;
            }
            .float .container:after{
                display: block;
                content: "";
                height: 0px;
                clear: both;
                overflow: hidden;
                zoom: 1;
            }

            /*方法二：position法*/
            .position{
                position: relative;
            }
            .position .left{
                position: absolute;
                top: 0px;
                left: 0px;
            }
            .position .right{
                position: absolute;
                top: 0px;
                right: 0px;
            }
            .position .center{
                height: 100%;
                margin: 0px 100px;
            }

            /*方法三：flex*/
            .flex{
                display: flex;
                flex-direction: row;
            }
            .flex .left,.right{
                flex-basis: 100px;
                -webkit-flex-basis: 100px;
            }
            .flex .center{
                flex-grow: 1;
            }

            /*方法四：table法*/
            .table{
                display: table;
            }
            .table .inner{
                display: table-cell;
            }


</style>
