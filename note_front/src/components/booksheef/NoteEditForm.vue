<template>
  <div>
    <el-dialog title="编辑自己标题简介" :visible.sync="dialogFormVisible" :before-close="handleClose">
      <el-form :model="form">
        <el-form-item label="笔记名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="笔记简介" :label-width="formLabelWidth">
          <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="form.abs" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancleEditNote">取消</el-button>
        <el-button type="primary" @click="updateNote">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: 'NoteEditForm',
    data() {
      return {
        isCreate:false,
        dialogFormVisible: false,
        form: {

        },
        currentCategoryId:'',

        formLabelWidth: '120px'
      };
    },
    methods: {
      handleClose(done) {
        var _this = this;
        this.$confirm('保存修改并关闭？')
          .then(_ => {
            _this.updateNote();
            done();
          })
          .catch(_ => {});
      },

      updateNote() {
        var _this = this;
        console.log(this.form);
        var url;
        if (!_this.isCreate){
          url = '/update/note/' + this.form.id+'/info';
        }
        else{
          url = '/update/category/'+this.currentCategoryId.toString()+'/note/add';

        }
        // console.log(url);
        this.axios.post(url, this.form)
          .then(function(response) {
            if (response.data.status === 200) {
              _this.dialogFormVisible = false;
              _this.$message({
                message: "编辑修改成功",
                type: 'success'
              });
              _this.$emit('updateInfo');
            } else {
              _this.$message.error("编辑失败！");
            }

          })
          .catch(function(erroe) {
            _this.$message.error("编辑失败！" + erroe);
          })
      },
      cancleEditNote() {
        this.dialogFormVisible = false;
      },
    }
  }
</script>

<style>
</style>
