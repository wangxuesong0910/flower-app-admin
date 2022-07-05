<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="98px">
      <!-- <el-form-item label="花的种类ID" prop="detailedId">
        <el-input
          v-model="queryParams.detailedId"
          placeholder="请输入花的种类ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="花的种类" prop="type">
        <el-input
          v-model="queryParams.type"
          placeholder="请输入花的种类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      
      <!-- <el-form-item label="花的进货价" prop="buyingPrice">
        <el-input
          v-model="queryParams.buyingPrice"
          placeholder="请输入花的进货价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="花的出货价" prop="exportPrice">
        <el-input
          v-model="queryParams.exportPrice"
          placeholder="请输入花的出货价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="花的折扣价" prop="discountPrice">
        <el-input
          v-model="queryParams.discountPrice"
          placeholder="请输入花的折扣价"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="花的入库时间" prop="enterDatetime">
        <el-date-picker clearable
          v-model="queryParams.enterDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择花的入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="花的出库时间" prop="takeoutDatetime">
        <el-date-picker clearable
          v-model="queryParams.takeoutDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择花的出库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="花的批发方式" prop="packaging">
        <el-input
          v-model="queryParams.packaging"
          placeholder="请选择花的批发方式：扎、捆、支、束..."
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="数量" prop="quantity">
        <el-input
          v-model="queryParams.quantity"
          placeholder="请输入数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="包含数量：例如一扎有多少支" prop="quantityIncluded">
        <el-input
          v-model="queryParams.quantityIncluded"
          placeholder="请输入包含数量：例如一扎有多少支"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="如果一扎花拆分开卖，已经售卖了多少" prop="salesQuantity">
        <el-input
          v-model="queryParams.salesQuantity"
          placeholder="请输入如果一扎花拆分开卖，已经售卖了多少"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="售卖方式" prop="modeOfSale">
        <el-input
          v-model="queryParams.modeOfSale"
          placeholder="请选择售卖方式：0:拆分|1:整卖(如果sales_quantity为空就为整卖，不为空就是拆分卖)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
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
          v-hasPermi="['erp:storage:add']"
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
          v-hasPermi="['erp:storage:edit']"
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
          v-hasPermi="['erp:storage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['erp:storage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="storageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="45" align="center" />
      <!-- <el-table-column label="${comment}" align="center" prop="id" /> -->
      <el-table-column label="类型" align="center" prop="type" />
      <el-table-column label="档次" align="center" prop="grade" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="进货价" align="center" prop="buyingPrice" />
      <el-table-column label="出货价" align="center" prop="exportPrice" />
      <el-table-column label="折扣价" align="center" prop="discountPrice" />
      <el-table-column label="仓储状态" align="center" prop="storageStatus" >
        <!-- <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enterDatetime, '{y}-{m}-{d}') }}</span>
        </template> -->
      </el-table-column>
      <el-table-column label="入库时间" align="center" prop="enterDatetime" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enterDatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出库时间" align="center" prop="takeoutDatetime" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.takeoutDatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="批发方式" align="center" prop="packaging" />
      <el-table-column label="数量" align="center" prop="quantity" />
      <!-- <el-table-column label="包含数量" align="center" prop="quantityIncluded" /> -->
      <el-table-column label="拆分售卖" align="center" prop="salesQuantity" />
      <!-- <el-table-column label="售卖方式" align="center" prop="modeOfSale" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['erp:storage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['erp:storage:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改鲜花的仓储信息单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="订单ID" prop="detailedId">
          <el-input v-model="form.detailedId" placeholder="请输入花的种类ID" />
        </el-form-item>
        <el-form-item label="花的档次" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入花的档次：低中高..." />
        </el-form-item>
        <el-form-item label="花的进货价" prop="buyingPrice">
          <el-input v-model="form.buyingPrice" placeholder="请输入花的进货价" />
        </el-form-item>
        <el-form-item label="花的出货价" prop="exportPrice">
          <el-input v-model="form.exportPrice" placeholder="请输入花的出货价" />
        </el-form-item>
        <el-form-item label="花的折扣价" prop="discountPrice">
          <el-input v-model="form.discountPrice" placeholder="请输入花的折扣价" />
        </el-form-item>
        <el-form-item label="花的入库时间" prop="enterDatetime">
          <el-date-picker clearable
            v-model="form.enterDatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择花的入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="花的出库时间" prop="takeoutDatetime">
          <el-date-picker clearable
            v-model="form.takeoutDatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择花的出库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="花的批发方式" prop="packaging">
          <el-input v-model="form.packaging" placeholder="请输入花的批发方式：扎、捆、支、束..." />
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入数量" />
        </el-form-item>
        <el-form-item label="包含数量" prop="quantityIncluded">
          <el-input v-model="form.quantityIncluded" placeholder="请输入包含数量：例如一扎有多少支" />
        </el-form-item>
        <el-form-item label="拆分售卖数" prop="salesQuantity">
          <el-input v-model="form.salesQuantity" placeholder="请输入如果一扎花拆分开卖，已经售卖了多少" />
        </el-form-item>
        <el-form-item label="售卖方式" prop="modeOfSale">
          <el-input v-model="form.modeOfSale" placeholder="请输入售卖方式：0:拆分|1:整卖(如果sales_quantity为空就为整卖，不为空就是拆分卖)" />
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
import { listStorage, getStorage, delStorage, addStorage, updateStorage, getFlowerDetailedType } from "@/api/erp/storage";

export default {
  name: "Storage",
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
      // 鲜花的仓储信息单表格数据
      storageList: [],
      // 鲜花的三级分类
      flowerType: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        grade: null,
        status: null,
        buyingPrice: null,
        exportPrice: null,
        discountPrice: null,
        storageStatus: null,
        enterDatetime: null,
        takeoutDatetime: null,
        packaging: null,
        quantity: null,
        quantityIncluded: null,
        salesQuantity: null,
        modeOfSale: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        detailedId: [
          // { required: true, message: "花的种类ID不能为空", trigger: "blur" }
        ],
        quantity: [
          // { required: true, message: "数量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询鲜花的仓储信息单列表 */
    getList() {
      this.loading = true;
      listStorage(this.queryParams).then(response => {
        this.storageList = response.rows;
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
        detailedId: null,
        grade: null,
        status: 0,
        buyingPrice: null,
        exportPrice: null,
        discountPrice: null,
        storageStatus: 0,
        enterDatetime: null,
        takeoutDatetime: null,
        packaging: null,
        quantity: null,
        quantityIncluded: null,
        salesQuantity: null,
        modeOfSale: null
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
      this.title = "添加鲜花的仓储信息单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStorage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改鲜花的仓储信息单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStorage(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStorage(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除鲜花的仓储信息单编号为"' + ids + '"的数据项？').then(function() {
        return delStorage(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('erp/storage/export', {
        ...this.queryParams
      }, `storage_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
