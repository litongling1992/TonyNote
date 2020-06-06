<template>
  <!-- <el-tabs @tab-click="handleClick">
    <el-tab-pane v-for="(item,i) in categories" :label="item.name" :key="i">
    </el-tab-pane>
  </el-tabs> -->
  <div style="margin-left: 10px">
    <category-bar @categorySelect="getNotes" ref="categoryBar">

    </category-bar>
    <notes>

    </notes>
  </div>
</template>

<script>
  import Notes from "./notes";
  import CategoryBar from "./CategoryBar";
  export default {
    name: "BookSheef",
    components: {
      Notes,
      CategoryBar
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
        console.log("Ok");
        var categoryBar = this.$refs.categoryBar.currentCid;
        console.log(categoryBar);
      }

    }
  }
</script>

<style>
  .el-tbas_item {
    height: 20px;
  }
</style>
