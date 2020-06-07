<template>
  <div style="text-align: initial;">
    <!-- style="display: inline-block;width: 20%;" -->
    <el-card v-for="(item,i) in notes" :key="i" class="box-card">
      <div slot="header" class="clearfix">
        <span class="">{{ item.name }}</span>
        <!-- <el-tooltip transition="0s" class="item" effect="dark" content="编辑笔记内容" placement="top-start">
          <el-button class="note-operation" type="text" @click="editNote(item.id)"><i class="el-icon-edit"></i></el-button>
        </el-tooltip>
        <el-tooltip transition="0s" class="item" effect="dark" content="详情" placement="top-start">
          <el-button class="note-operation" type="text" @click="editInfo(item)"><i class="el-icon-edit-outline"></i></el-button>
        </el-tooltip>
        <el-tooltip transition="0s" class="item" effect="dark" content="删除此笔记" placement="top-start">
          <el-button class="note-operation" type="text" @click="deleteNote(item.id)"><i class="el-icon-delete"></i></el-button>
        </el-tooltip> -->
        <el-tooltip transition="0s" class="item" effect="dark" content="编辑笔记内容" placement="top-start">
          <el-button class="note-operation" type="text"><i class="el-icon-edit"></i></el-button>
        </el-tooltip>
        <el-tooltip transition="0s" class="item" effect="dark" content="查看笔记内容" placement="top-start">
          <el-button class="note-operation" type="text"><i class="el-icon-more"></i></el-button>
        </el-tooltip>
       <el-tooltip transition="0s" class="item" effect="dark" content="编辑笔记标题与简介" placement="top-start">
         <el-button class="note-operation" type="text"> <i class="el-icon-edit-outline"></i></el-button>
       </el-tooltip>
        <!--  <el-button style="float: right; padding: 3px 0" type="text">
          <i class="el-icon-edit"></i>
        </el-button>
        <el-button style="float: right; padding: 3px 0;margin-right: 5px;" type="text">
          <i class="el-icon-more"></i>
        </el-button>
        <el-button style="float: right; padding: 3px 0;margin-right: 5px;" type="text">
          <i class="el-icon-edit-outline"></i>
        </el-button> -->
      </div>
      <div class="text item">
        {{ item.abs }}
      </div>
      <div class="text item">
       <el-tooltip transition="0s" class="item" effect="dark" content="查看笔记内容" placement="top-start">
         <el-button class="note-operation" type="text"><i class="el-icon-more"></i></el-button>
       </el-tooltip>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: 'notes',
    data() {
      return {
        notes: []
      };
    }
  }
</script>

<style>
  /* .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  } */

  .box-card {
   /* //width: 250px; */
   display: inline-block;
   width: 30%;
   margin-left: 5px;
   margin-right: 5px;
  }

  .note-operation{
    float: right;
    padding: 3px 0;
    margin-right: 2px;
    margin-left: 2px!important;
  }
 .note-title{
      font-weight: bolder;
    }

  /*

    .note-abs{
      font-size: 12px;
      height: 50px;
      cursor: pointer;
    }

    .el-card__header {
      padding: 9px 20px!important;
      height: 40px!important;
    }
    .page{
      text-align: center;
      position:fixed;
      margin:auto;
      left:0;
      right:0;
      bottom:0;
      width:200px;
      height:50px;
    } */
</style>
