<template>
  <div class="app-container">
    <el-form :model="queryParamsDetailed" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="分类" prop="type">
        <!-- <el-select v-model="value" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>  -->
      </el-form-item>
      <!-- <el-form-item label="花的科属ID" prop="ascriptionId">
        <el-input
          v-model="queryParams.ascriptionId"
          placeholder="请输入花的科属ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="花的品种ID" prop="varietiesId">
        <el-input
          v-model="queryParams.varietiesId"
          placeholder="请输入花的品种ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="创建者" prop="creator">
        <el-input
          v-model="queryParams.creator"
          placeholder="请输入创建者"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <!-- <el-form-item label="创建时间" prop="createDatetime">
        <el-date-picker clearable
          v-model="queryParams.createDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="修改时间" prop="modifyDatetime">
        <el-date-picker clearable
          v-model="queryParams.modifyDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择修改时间">
        </el-date-picker>
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['erp:detailed:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['erp:detailed:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['erp:detailed:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['erp:detailed:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="detailedListBo" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键id" align="center" prop="id" /> -->
      <el-table-column label="花的种类" align="center" prop="type" />
      <el-table-column label="花的颜色" align="center" prop="color" />
      <el-table-column label="花的科属" align="center" prop="ascription" />
      <el-table-column label="花的品种" align="center" prop="varieties" />
      <el-table-column label="创建者" align="center" prop="creator" />
      <el-table-column label="修改时间" align="center" prop="modifyDatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifyDatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['erp:detailed:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['erp:detailed:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParamsDetailedBo.pageNum"
      :limit.sync="queryParamsDetailedBo.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="花的颜色：红橙黄绿等" prop="color">
          <el-input v-model="form.color" placeholder="请输入花的颜色：红橙黄绿等" />
        </el-form-item>
        <el-form-item label="花的科属ID" prop="ascriptionId">
          <el-input v-model="form.ascriptionId" placeholder="请输入花的科属ID" />
        </el-form-item>
        <el-form-item label="花的品种ID" prop="varietiesId">
          <el-input v-model="form.varietiesId" placeholder="请输入花的品种ID" />
        </el-form-item>
        <el-form-item label="创建者" prop="creator">
          <el-input v-model="form.creator" placeholder="请输入创建者" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createDatetime">
          <el-date-picker clearable
            v-model="form.createDatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="修改时间" prop="modifyDatetime">
          <el-date-picker clearable
            v-model="form.modifyDatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择修改时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDetailed, getDetailed, delDetailed, addDetailed, updateDetailed, listDetailedBo } from "@/api/erp/detailed";
import { listAscription, getAscription, delAscription, addAscription, updateAscription } from "@/api/erp/ascription";
import { listVarieties, getVarieties, delVarieties, addVarieties, updateVarieties } from "@/api/erp/varieties";

export default {
  name: "flowermanager",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)表格数据
      detailedList: [],
      // 花的种类科属，二级分类等
      detailedListBo: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询花的品种科属：玫瑰、百合等等，蔷薇科等
      queryParamsDetailedBo: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        color: null,
        varieties: null,
        ascription: null,
        creator: null,
        modifyDatetime: null
      },
      // 查询三级分类种类参数
      queryParamsDetailed: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        color: null,
        ascriptionId: null,
        varietiesId: null,
        creator: null,
        createDatetime: null,
        modifyDatetime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // type: [
        //   { required: true, message: "花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰不能为空", trigger: "change" }
        // ],
        // ascriptionId: [
        //   { required: true, message: "花的科属ID不能为空", trigger: "blur" }
        // ],
        // varietiesId: [
        //   { required: true, message: "花的品种ID不能为空", trigger: "blur" }
        // ],
        // creator: [
        //   { required: true, message: "创建者不能为空", trigger: "blur" }
        // ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)列表 */
    getList() {
      this.loading = true;
      listDetailedBo(this.queryParams).then(response => {
        this.detailedListBo = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        type: null,
        color: null,
        ascriptionId: null,
        varietiesId: null,
        creator: null,
        createDatetime: null,
        modifyDatetime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDetailed(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDetailed(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetailed(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除花的种类：例如：玫瑰属：卡罗拉、白玫瑰、紫玫瑰(三级分类)编号为"' + ids + '"的数据项？').then(function() {
        return delDetailed(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('erp/detailed/export', {
        ...this.queryParams
      }, `detailed_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
