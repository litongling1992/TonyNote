<template>
  <!-- <el-tabs @tab-click="handleClick">
    <el-tab-pane v-for="(item,i) in categories" :label="item.name" :key="i">
    </el-tab-pane>
  </el-tabs> -->
  <div style="margin-left: 10px">
    <category-bar @categorySelect="getNotes" ref="categoryBar">
    </category-bar>
    <notes ref="notes" @editInfo="handleEditInfos" @addNote="handleAddNote">
    </notes>
    <note-edit-form ref="noteEditForm" @updateInfo="getNotes"></note-edit-form>
  </div>
</template>

<script>
  import Notes from "./notes";
  import CategoryBar from "./CategoryBar";
  import NoteEditForm from "./NoteEditForm";
  export default {
    name: "BookSheef",
    components: {
      Notes,
      CategoryBar,
      NoteEditForm,
    },
    data() {
      return {
        //categories: [],
      };
    },
    /*    mounted() {
       var _this = this;
       this.axios.get("/categories")
         .then(function(response) {
           if (response.status === 200) {
             _this.categories = response.data
           }
           console.log(response);
         })
     },
     methods: {
       handleClick(tab, event) {
         console.log(tab, event);
       }
     } */
    methods: {
      getNotes() {
        var _this = this;
        var categoryBarId = this.$refs.categoryBar.currentCid;
        // console.log("Get CategoryId Ok: " + categoryBarId);
        //根据id获取目录内容
        this.axios.get('categories/' + categoryBarId + '/notes')
          .then(function(response) {
            if (response.status === 200) {
              //console.log(_this.$refs.notes.notes);
              _this.$refs.notes.notes = response.data;
            }

          })
      },
      handleEditInfos(noteInfo) {
        this.$refs.noteEditForm.dialogFormVisible = true;
        this.$refs.noteEditForm.isCreate = false;
        this.$refs.noteEditForm.form = noteInfo;
      },
      handleAddNote() {
        var categoryBarId = this.$refs.categoryBar.currentCid;
        this.$refs.noteEditForm.dialogFormVisible = true;
        this.$refs.noteEditForm.isCreate = true;
        this.$refs.noteEditForm.form = {};
        this.$refs.noteEditForm.currentCategoryId = this.$refs.categoryBar.currentCid;
      },

    }
  }
</script>

<style>
  .el-tbas_item {
    height: 20px;
  }
</style>
