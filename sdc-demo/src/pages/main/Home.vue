<template>
  <div class="contant_box">
    <div class="new_title_style"><h1>SDC_DEMO:分布式消息总线</h1></div>
    <div class="el_cont">

      <div class="add_table">
        <el-table stripe :data="distrMsgBusDataList">
          <el-table-column type="index" :index="indexConvert" label="序号" width="120"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_IDENTITY" label="Kafka标识"
                           width="120"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_URL" label="kafka地址"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_VERSION" label="kafka版本"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_TOPIC" label="topic"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_PARTITION" label="分区数"></el-table-column>
          <el-table-column :show-overflow-tooltip="true" prop="KFK_REPLICATION" label="副本数"></el-table-column>
          <el-table-column label="操作" width="250">
            <template slot-scope="scope">
              <el-button type="primary" @click="showDistrMsgBusData(scope.row)">修改</el-button>
              <el-button type="danger" @click="deleteMsgBusData(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="el_pagination">
          <el-pagination background
                         @size-change="handleSizeChange"
                         @current-change="handleCurrentChange"
                         :current-page.sync="currentPage"
                         layout="total, pager, next" :total="totalCounts">
          </el-pagination>
        </div>
      </div>

    </div>

    <div class="dialog_box">
      <el-dialog title="新增"
                 :visible.sync="dialogVisibleAdd"
                 :before-close="handleCloseMsgBus"
                 :close-on-click-modal="false"
                 v-loading="loadingAddForm"
                 element-loading-spinner="el-icon-loading"
                 element-loading-text="提交中"
                 element-loading-background="rgba(0, 0, 0, 0.6)"
                 class="width45">
        <el-form :model="addDistrMsgBus" ref="addDistrMsgBus" :rules="addRulesBus" label-width="180px">
          <el-form-item prop="KFK_IDENTITY" label="Kafka标识：">
            <el-input v-model="addDistrMsgBus.KFK_IDENTITY" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_URL" label="kafka地址：">
            <el-input v-model="addDistrMsgBus.KFK_URL" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_VERSION" label="kafka版本：">
            <el-input v-model="addDistrMsgBus.KFK_VERSION" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_TOPIC" label="topic：">
            <el-input v-model="addDistrMsgBus.KFK_TOPIC" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_PARTITION" label="分区数：">
            <el-input v-model.number="addDistrMsgBus.KFK_PARTITION" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_REPLICATION" label="副本数：">
            <el-input v-model.number="addDistrMsgBus.KFK_REPLICATION" placeholder=""></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="resetFormDataBus('addDistrMsgBus')" plain>取 消</el-button>
                <el-button type="primary" @click="addMsgBusData('addDistrMsgBus')">确 定</el-button>
            </span>
      </el-dialog>

      <!--修改操作弹窗-->
      <el-dialog title="修改"
                 :visible.sync="dialogVisibleUpdate"
                 :close-on-click-modal="false"
                 :before-close="handleCloseUpMsgBus"
                 v-loading="loadingUpdateForm"
                 element-loading-spinner="el-icon-loading"
                 element-loading-text="提交中"
                 element-loading-background="rgba(0, 0, 0, 0.6)"
                 class="width45">
        <el-form :rules="addRulesBus" :model="updateDistrMsgBus" ref="updateDistrMsgBus" label-width="180px">
          <el-form-item prop="KFK_IDENTITY" label="Kafka标识：">
            <el-input v-model="updateDistrMsgBus.KFK_IDENTITY" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_URL" label="kafka地址：">
            <el-input v-model="updateDistrMsgBus.KFK_URL" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_VERSION" label="kafka版本：">
            <el-input v-model="updateDistrMsgBus.KFK_VERSION" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_TOPIC" label="topic：">
            <el-input v-model="updateDistrMsgBus.KFK_TOPIC" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_PARTITION" label="分区数：">
            <el-input v-model.number="updateDistrMsgBus.KFK_PARTITION" placeholder=""></el-input>
          </el-form-item>
          <el-form-item prop="KFK_REPLICATION" label="副本数：">
            <el-input v-model.number="updateDistrMsgBus.KFK_REPLICATION" placeholder=""></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
                     <el-button type="primary" @click="resetFormDataBusUpdate('updateDistrMsgBus')" plain>取 消</el-button>
                     <el-button type="primary" @click="updateFormDataBus('updateDistrMsgBus')">确 定</el-button>
                 </span>
      </el-dialog>

    </div>
  </div>
</template>

<script>
import {DistrMsgService} from '@/service'

// eslint-disable-next-line camelcase
var reg_illegal_char = /[<>'"&]/

export default {
  name: 'Home',
  data: function () {
    var illegalCharValidate = function (rule, value, callback) {
      if (value !== '' && reg_illegal_char.test(value)) {
        callback(new Error('不允许输入非法字符< > \' " &'))
      }
      callback()
    }
    var checkKfkIdentity = (rule, value, callback) => {
      var that = this
      if (!value.trim()) {
        return callback(new Error('Kafka标识不能为空'))
      }
      that.checkKfkIdentity(value, callback)
    }
    return {
      /* 搜索参数容器 */
      searchFormBus: {
        kfkUrl: '',
        kfkTopic: ''
      },
      searchFormContainer: {
        kfkUrl: '',
        kfkTopic: ''
      },
      /* 弹框显示标识 */
      dialogVisibleAdd: false,
      dialogVisibleUpdate: false,
      loadingAddForm: false,
      loadingUpdateForm: false,
      /* 列表段参数 */
      distrMsgBusDataList: [],
      totalCounts: 0,
      currentPage: 1,
      pageSize: 10,
      loading: false,
      /* 添加操作参数 */
      addDistrMsgBus: {
        KFK_IDENTITY: '',
        KFK_URL: '',
        KFK_VERSION: '',
        KFK_TOPIC: '',
        KFK_PARTITION: '',
        KFK_REPLICATION: ''
      },
      /* 新增表单校验规则 */
      addRulesBus: {
        KFK_IDENTITY: [
          {required: true, message: 'kafka标识必填', trigger: 'blur'},
          {validator: illegalCharValidate, trigger: 'blur'},
          {validator: checkKfkIdentity, trigger: 'blur'},
          {min: 1, max: 20, message: '长度须小于20个字符', trigger: 'blur'}
        ],
        KFK_URL: [
          {required: true, message: 'kafka地址必填', trigger: 'blur'},
          {validator: illegalCharValidate, trigger: 'blur'},
          {min: 1, max: 400, message: '长度须小于400个字符', trigger: 'blur'}
        ],
        KFK_VERSION: [
          {required: true, message: 'kafka版本必填', trigger: 'blur'},
          {validator: illegalCharValidate, trigger: 'blur'},
          {min: 1, max: 64, message: '长度须小于64个字符', trigger: 'blur'}
        ],
        KFK_TOPIC: [
          {required: true, message: 'topic必填', trigger: 'blur'},
          {validator: illegalCharValidate, trigger: 'blur'},
          {min: 1, max: 200, message: '长度须小于200个字符', trigger: 'blur'}
        ],
        KFK_PARTITION: [
          {required: true, message: '分区数必填', trigger: 'blur'},
          {type: 'number', message: '分区数须为数字值', trigger: 'blur'},
          {pattern: /^([1-9]\d{0,3}|10000)$/, message: '范围在1-10000', trigger: 'blur'}
        ],
        KFK_REPLICATION: [
          {required: true, message: '副本数必填', trigger: 'blur'},
          {type: 'number', message: '副本数须为数字值', trigger: 'blur'},
          {pattern: /^([1-9]\d{0,3}|10000)$/, message: '范围在1-10000', trigger: 'blur'}
        ]
      },
      searchRules: {
        kfkUrl: [
          {validator: illegalCharValidate, trigger: 'blur'},
          {min: 1, max: 64, message: '长度须小于400个字符', trigger: 'blur'}
        ],
        kfkTopic: [
          {validator: illegalCharValidate, trigger: 'blur'},
          {min: 1, max: 200, message: '长度须小于200个字符', trigger: 'blur'}
        ]
      },
      /* 更新操作参数 */
      updateDistrMsgBus: {
        ID: '',
        KFK_IDENTITY: '',
        KFK_URL: '',
        KFK_VERSION: '',
        KFK_TOPIC: '',
        KFK_PARTITION: '',
        KFK_REPLICATION: ''
      }

    }
  },
  mounted: function () {
    this.getPageBusDataList()
  },
  methods: {
    /* 校验db标识的唯一性 */
    checkKfkIdentity: function (value, callback) {
      var data = {
        handler: 'DistrMsgBusHandler',
        action: 'getMsgBusByIde',

        kfkIdentity: value,
        ID: '',
        IDF: this.updateDistrMsgBus.ID
      }
    },
    /* 表单筛选查询 */
    searchBusDataFilter: function () {
      this.$refs['searchFormBus'].validate(function (valid) {
        // 校验通过时
        if (valid) {
          this.searchFormContainer.kfkUrl = this.searchFormBus.kfkUrl
          this.searchFormContainer.kfkTopic = this.searchFormBus.kfkTopic
          this.currentPage = 1
          this.getPageBusDataList()
        }
      })
    },
    /* 列表分页函数 */
    async getPageBusDataList () {
      this.loading = true

      var data = {
        handler: 'DistrMsgBusHandler',
        action: 'getDistrMsgBus',

        kfkUrl: this.searchFormContainer.kfkUrl,
        kfkTopic: this.searchFormContainer.kfkTopic,

        currentPage: this.currentPage,
        pageSize: this.pageSize
      }

      const result = await DistrMsgService.listMsgBus(data)
      console.log('------', result)
      console.log('------', result.data)
      if (result.code === 200) {
        this.distrMsgBusDataList = result.data.rows
        this.totalCounts = parseInt(result.data.totalCounts)
        this.currentPage = parseInt(result.data.currentPage)
      } else {
        this.totalCounts = 0
        this.currentPage = 1
      }
    },
    /* 计算展示序号 */
    indexConvert (index) {
      return (this.currentPage - 1) * this.pageSize + index + 1
    },
    handleSizeChange: function (value) {
    },
    handleCurrentChange: function (value) {
      this.getPageBusDataList()
    },
    /* 表单重置 */
    resetFormDataBus: function (formName) {
      this.$refs[formName].resetFields()
      this.dialogVisibleAdd = false
    },
    handleCloseMsgBus: function (done) {
      /* dom加载的顺序问题 */
      if (done) {
        this.$refs['addDistrMsgBus'].resetFields()
      }
      this.dialogVisibleAdd = false
    },
    /* 删除操作 */
    deleteMsgBusData: function (row) {
      this.$confirm('此操作将永久删除记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        closeOnClickModal: false,
        type: 'warning'
      }).then(() => {
        var data = {
          handler: 'DistrMsgBusHandler',
          action: 'deleteMsgBusData',

          ID: row.ID
        }
      }).catch(() => {

      })
    },
    /* 数据回显 */
    async showDistrMsgBusData (row) {
      this.dialogVisibleUpdate = true

      var data = {
        handler: 'DistrMsgBusHandler',
        action: 'getMsgBusByIde',
        kfkIdentity: '',
        ID: row.ID,
        IDF: ''
      }

      const result = await DistrMsgService.listMsgBus(data)
      if (result.code === 200) {
        Object.assign(this.updateDistrMsgBus, result.data)
      } else {
        this.messageTips('error', '查询失败')
      }
    },
    /* 更新函数 */
    async updateFormDataBus (formName) {
      this.dialogVisibleUpdate = true
      const update = this.$refs[formName].validate()
      if (update) {
        var formUpdateValue = this.updateDistrMsgBus

        var data = {
          handler: 'DistrMsgBusHandler',
          action: 'updateMsgBusData',

          ID: formUpdateValue.ID,
          KFK_IDENTITY: formUpdateValue.KFK_IDENTITY,
          KFK_URL: formUpdateValue.KFK_URL,
          KFK_VERSION: formUpdateValue.KFK_VERSION,
          KFK_TOPIC: formUpdateValue.KFK_TOPIC,
          KFK_PARTITION: formUpdateValue.KFK_PARTITION,
          KFK_REPLICATION: formUpdateValue.KFK_REPLICATION
        }

        const result = await DistrMsgService.commonPost(data)
        if (result.code === 200) {
          this.currentPage = 1
          this.getPageBusDataList()

          this.$refs[formName].resetFields()
          this.updateDistrMsgBus.ID = ''
          this.dialogVisibleUpdate = false

          this.messageTips('success', '修改成功')
        } else {
          this.messageTips('error', '修改失败')
        }
      } else {
        this.loadingUpdateForm = false
        this.messageTips('error', '服务器未响应')
      }
    },
    /* 表单重置 */
    resetFormDataBusUpdate: function (formName) {
      this.$refs[formName].resetFields()
      this.updateDistrMsgBus.ID = ''
      this.dialogVisibleUpdate = false
    },
    handleCloseUpMsgBus: function (done) {
      /* dom加载的顺序问题 */
      if (done) {
        this.$refs['updateDistrMsgBus'].resetFields()
        this.updateDistrMsgBus.ID = ''
      }
      this.dialogVisibleUpdate = false
    },
    /* 一句话展示提示 */
    messageTips: function (type, message) {
      this.$message({
        showClose: true,
        message: message,
        type: type,
        duration: '3000'
      })
    }

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .left_float {
    float: left;
  }

  .right_float {
    float: right;
  }

  .logo {
    float: left;
  }

  .logo img {
    padding-top: 0.2rem;
    border: none;
    height: 1.6rem;
  }

  .avatar {
    float: right;
    margin-right: 1rem;
  }

  .demo-basic--circle {
    margin-top: 0.3rem;
  }

  .logout a {
    color: #fff;
    text-decoration: none;
    font-size: 0.1rem;
  }

  .logoName {
    color: #eee;
    text-align: center;
    font-size: 1.3rem;
    margin-right: 1rem;
  }

  /*search form position*/
  .search_movie {
    position: absolute;
    margin-left: 70%;
    margin-top: 0.3rem
  }

  /*bottom information*/
  footer.footer {
    /*height: 4rem!important;*/
    height: auto !important;
    background-color: #545c64;
    color: #98A7B5;
    font-size: 0.3rem;
    z-index: 111;
  }

  footer.footer a {
    color: #ef4238;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }
</style>
