<template>
<div class="cinema_content">
  <!-- 顶部待选 -->
  <div class="top_wait_choose">
    <!--品牌-->
    <div class="content clearfix">
      <div class="brand">品牌:</div>
      <ul class="brand-ul">
        <li><a href="#" :class="branch === '' ? 'active' : ''" @click="changeActive('')" >全部</a></li>
        <li><a href="#" :class="branch === 1 ? 'active' : ''" @click="changeActive(1)">幸福蓝海国际影城</a></li>
        <li><a href="#" :class="branch === 2 ? 'active' : ''" @click="changeActive(2)">万达影城</a></li>
        <li><a href="#" :class="branch === 3 ? 'active' : ''" @click="changeActive(3)">金逸影城</a></li>
        <li><a href="#" :class="branch === 4 ? 'active' : ''" @click="changeActive(4)">卢米埃影城</a></li>
        <li><a href="#" :class="branch === 5 ? 'active' : ''" @click="changeActive(5)">中影国际影城</a></li>
        <li><a href="#" :class="branch === 6 ? 'active' : ''" @click="changeActive(6)">横店电影城</a></li>
        <li><a href="#" :class="branch === 7 ? 'active' : ''" @click="changeActive(7)">大地影院</a></li>
        <li><a href="#" :class="branch === 8 ? 'active' : ''" @click="changeActive(8)">大地影院</a></li>
        <li><a href="#" :class="branch === 9 ? 'active' : ''" @click="changeActive(9)">UME国际影城</a></li>
        <li><a href="#" :class="branch === 10 ? 'active' : ''" @click="changeActive(10)">海上国际影城</a></li>
        <li><a href="#" :class="branch === 11 ? 'active' : ''" @click="changeActive(11)">星美国际影城</a></li>
        <li><a href="#" :class="branch === 12 ? 'active' : ''" @click="changeActive(12)">耀莱成龙国际影城</a></li>
        <li><a href="#" :class="branch === 13 ? 'active' : ''" @click="changeActive(13)">CGV影城</a></li>
        <li><a href="#" :class="branch === 14 ? 'active' : ''" @click="changeActive(14)">星河国际影城</a></li>
        <li><a href="#" :class="branch === 15 ? 'active' : ''" @click="changeActive(15)">艾米1895影院</a></li>
        <li><a href="#" :class="branch === 16 ? 'active' : ''" @click="changeActive(16)">沃美影城</a></li>
        <li><a href="#" :class="branch === 17 ? 'active' : ''" @click="changeActive(17)">SFC上影影城</a></li>
        <li><a href="#" :class="branch === 18 ? 'active' : ''" @click="changeActive(18)">保利国际影城</a></li>
        <li><a href="#" :class="branch === 19 ? 'active' : ''" @click="changeActive(19)">其他</a></li>
      </ul>
    </div>
    <!--特殊厅-->
    <div class="content clearfix">
      <div class="specialHall">特殊厅:</div>
      <ul class="specialHall-ul">
        <li><a href="#" :class="specialHall === '' ? 'active' : ''" @click="changeSpActive('')">全部</a></li>
        <li><a href="#" :class="specialHall === 1 ? 'active' : ''" @click="changeSpActive(1)">IMAX厅</a></li>
        <li><a href="#" :class="specialHall === 2 ? 'active' : ''" @click="changeSpActive(2)">CGS中国巨幕厅</a></li>
        <li><a href="#" :class="specialHall === 3 ? 'active' : ''" @click="changeSpActive(3)">杜比全景声厅</a></li>
        <li><a href="#" :class="specialHall === 4 ? 'active' : ''" @click="changeSpActive(4)">Dolby Cinema厅</a></li>
        <li><a href="#" :class="specialHall === 5 ? 'active' : ''" @click="changeSpActive(5)">RealD厅</a></li>
        <li><a href="#" :class="specialHall === 6 ? 'active' : ''" @click="changeSpActive(6)">RealD 6FL厅</a></li>
        <li><a href="#" :class="specialHall === 7 ? 'active' : ''" @click="changeSpActive(7)">4DX厅</a></li>
        <li><a href="#" :class="specialHall === 8 ? 'active' : ''" @click="changeSpActive(8)">DTS:X 临境音厅</a></li>
        <li><a href="#" :class="specialHall === 9 ? 'active' : ''" @click="changeSpActive(9)">儿童厅</a></li>
        <li><a href="#" :class="specialHall === 10 ? 'active' : ''" @click="changeSpActive(10)">4K厅</a></li>
        <li><a href="#" :class="specialHall === 11 ? 'active' : ''" @click="changeSpActive(11)">4D厅</a></li>
        <li><a href="#" :class="specialHall === 12 ? 'active' : ''" @click="changeSpActive(12)">巨幕厅</a></li>
      </ul>
    </div>
  </div>

  <div class="cinemas-list" v-loading="loading">
    <h2 class="cinemas-list-header">影院列表</h2>
    <!--影院数据查询-->
    <div class="cinema-cell clearfix" v-for="cinema in cinemaList" v-bind:key="cinema['cinema_id']">
      <div class="cinema-info">
        <a href="#">{{cinema['cinema_name']}}</a>
        <p>{{cinema['cinema_address']}}</p>
      </div>

      <div class="buy-btn">
        <el-button type="danger" size="small" round @click="toChoseHall(cinema['cinema_id'])">选座购票</el-button>
      </div>

      <div class="price">
        <span class="rmb red">￥</span>
        <span class="price-num red"><strong>{{cinema['cinema_price']}}</strong></span>
        <span>起</span>
      </div>
    </div>
  </div>

  <div class="pagination">
    <el-pagination
      :background="true"
      layout="prev, pager, next"
      @current-change="handleCurrentChange"
      :current-page.sync="pageNum"
      :total="total">
    </el-pagination>
  </div>
</div>
</template>

<script>
export default {
  name: 'Cinema',
  data () {
    return {
      branch: '',
      specialHall: '',
      cinemaList: [],
      loading: false,
      total: 0,
      pageSize: 10,
      pageNum: 1
    }
  },
  created () {
    this.searchCinemas()
  },
  methods: {
    // 页面点击切换分页的事件
    handleCurrentChange (val) {
      this.searchCinemas()
    },
    changeActive (code) {
      this.branch = code
      this.searchCinemas()
    },
    changeSpActive (code) {
      this.specialHall = code
      this.searchCinemas()
    },
    searchCinemas () {
      let movieId = this.$route.query.movieId
      this.loading = true
      this.axios.post('/sakura/Cinema/search', {
        branch_id: this.branch,
        special_id: this.specialHall,
        pageSize: this.pageSize,
        pageNum: this.pageNum,
        movieId: movieId
      }).then(response => {
        this.loading = false
        if (response['data'].code === 200) {
          const cinemas = response['data']['data']
          this.cinemaList = cinemas['list']
          this.total = cinemas['total']
          this.pageNum = cinemas['pageNum']
        } else {
          this.$message({
            message: '查询失败，请确认网络环境后重试',
            type: 'error'
          })
        }
      }).catch(exception => {
        this.loading = false
        this.$message({
          message: '查询失败，请确认网络环境后重试',
          type: 'error'
        })
      })
    },
    toChoseHall (cinemaId) {
      let userStr = localStorage.getItem('user')
      let user = JSON.parse(userStr)
      if (user == null) {
        this.$message({
          message: '请登录后，重新点击购买...',
          type: 'error'
        })
        return
      }
      if (this.$route.query.movieId) {
        this.$router.push({
          name: 'mHall',
          params: {
            cinemaId: cinemaId,
            movieId: this.$route.query.movieId
          }
        })
      } else {
        this.$router.push('/index')
      }
    }
  }
}
</script>

<style scoped>
.cinema_content {
  width: 100%;
  height: 100%;
  overflow: auto;
}
.top_wait_choose {
  border: 1px solid #e5e5e5
}
.content {
  border-bottom: 1px dashed #e5e5e5;
  margin: 30px 30px 30px 30px;
}
.content:last-child {
  border-bottom: none;
  margin: 30px 30px 0 30px;
}
.brand,.specialHall {
  float: left;
  width: 56px;
  color: #999;
}
.brand-ul,.specialHall-ul {
  list-style: none;
}
.brand-ul li,.specialHall-ul li {
  float: left;
  margin-left: 1rem;
  margin-bottom: 0.5rem;
}
.brand-ul li a,.specialHall-ul li a {
  text-decoration: none;
  color: #333;
  font-size: 14px;
  padding: 10px;
}
.brand-ul li a:hover,.specialHall-ul li a:hover {
  text-decoration: none;
  color: #f34d41;
  font-size: 14px;
}
.brand-ul li a.active:hover,.specialHall-ul li a.active:hover {
  text-decoration: none;
  color: #e5e5e5;
  font-size: 14px;
}
.active {
  color: #e5e5e5!important;
  background-color: #f34d41;
  border-radius: 20px;
}
.cinemas-list {
  margin: 1rem 3rem 0 3rem;
}
.cinemas-list-header {
  font-size: 18px;
  color: #333;
  border-left: 4px solid #f03d37;
  padding-left: 6px;
  line-height: 18px;
  text-align: left;
}
.cinema-cell {
  text-align: left;
  border-bottom: 1px dashed #e5e5e5;
  margin-bottom: 1rem;
}
.cinema-cell:last-child {
  border-bottom: none;
}
.cinema-info {
  float: left;
}
.cinema-info a {
  text-decoration: none;
  color: #333;
  font-size: 14px;
}
.cinema-info a:hover {
  text-decoration: none;
  color: #f34d41;
  font-size: 14px;
}
.cinema-info p{
  font-size: 14px;
  line-height: 14px;
  color: #999;
}
.buy-btn {
  float: right;
}
.price {
  padding: 9px 15px;
  float: right;
  color: #f34d41;
}
.pagination {
  margin-bottom: 2rem;
}
</style>
