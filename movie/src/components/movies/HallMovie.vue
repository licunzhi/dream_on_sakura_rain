<template>
  <div style="width: 100%; height: 100%; overflow: visible;" class="hallMovie-content">
    <h3 class="hall_title">可选放映厅</h3>
    <!--目前可以售卖的放映厅的信息-->
    <div v-for="item in hallMovies" v-bind:key="item['screen_id']" class="clearfix">
      <div class="hall_info left">
        <p style="text-align: left"><i class="el-icon-video-camera-solid"></i>&nbsp;&nbsp;<b>{{item['hall_name']}}</b></p>
        <p><i>{{item['cinema_name']}}</i></p>
      </div>

      <div class="screen-time left">
        <span>场次时间:</span>
        <span>{{item['SCREENTIME']}}</span>
      </div>

      <div class="price right">
        <span class="rmb red">￥</span>
        <span class="price-num red"><strong>{{item['movie_price']}}</strong></span>
        <span>起</span>

        <div class="buy-btn">
          <el-button type="danger" size="small" round @click="toChooseSets(item)">选座购票</el-button>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: 'HallMovie',
  data () {
    return {
      cinemaId: this.$route.params.cinemaId,
      movieId: this.$route.params.movieId,
      hallMovies: []
    }
  },
  created () {
    this.hallMoviesMethod(this.cinemaId, this.movieId)
  },
  methods: {
    hallMoviesMethod: function (cinemaId, movieId) {
      this.axios.post('/sakura/Movie/halls', {
        cinemaId: cinemaId,
        movieId: movieId
      }).then(response => {
        this.loading = false
        if (response['data'].code === 200) {
          const cinemas = response['data']['data']
          this.hallMovies = cinemas['list']
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
    toChooseSets: function (item) {
      /* 现在临时拦截操作，以后需要重新编写路由守卫实现 */
      let userStr = localStorage.getItem('user')
      let user = JSON.parse(userStr)
      if (user == null) {
        this.$message({
          message: '请登录后，重新点击购买...',
          type: 'error'
        })
        return
      }

      this.$router.push({
        name: 'mBuySet',
        params: {
          item: item
        }
      })
    }
  }
}
</script>

<style scoped>
.hall_title {
  font-size: 18px;
  color: #333;
  border-left: 4px solid #f03d37;
  padding-left: 6px;
  line-height: 18px;
  text-align: left;
}
.screen-time {
  padding: 1.8rem 0 0 1rem;
}
.price {
  margin: 0.5rem 2rem 0 0;
}
</style>
