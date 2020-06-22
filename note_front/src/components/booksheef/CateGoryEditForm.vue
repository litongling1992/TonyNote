<template>
  <div>
   <el-dialog title="编辑笔记分类" :visible.sync="dialogFormVisible" :before-close="handleClose">
      <el-form :model="form">
        <el-form-item label="分类名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancleEditCategory">取消</el-button>
        <el-button type="primary" @click="updateCateGory">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default{
    name: 'CategoryEditForm',
    data() {
      return {
        isCreate:false,
         formLabelWidth: '120px',
        dialogFormVisible: false,
        form: {

        },
      };
    },
    methods:{

    }
  }
</script>

<style>
</style>
