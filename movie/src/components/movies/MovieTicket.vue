<template>
  <div class="mt-content clearfix">
    <div class="left-content left">
      <div class="header-guider">
        <el-breadcrumb separator=">">
          <el-breadcrumb-item :to="{ path: '/movies' }">电影</el-breadcrumb-item>
          <el-breadcrumb-item>购票</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

      <div class="ticket-item clearfix">
        <div class="movie-detail">
          <div class="left">
            <img :src="moviePic">
          </div>
          <div class="left introduce">
            <h3>{{movie['movie_name']}}</h3>
            <h3>{{movie['movie_foreign_name']}}</h3>
            <p>剧情,动作,悬疑,犯罪</p>
            <p><span>中国香港,中国大陆</span> / <span>{{movie['movie_long']}}</span>分钟</p>
          </div>
        </div>
      </div>
      <div class="word_break_line">
        <p>剧情简介</p>
        {{movie['movie_desc']}}
      </div>
    </div>
    <div class="right-content left">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import ImageConst from '@/components/constants/ImageConst'
import Cinema from '@/components/cinema/Cinema.vue'

export default {
  name: 'MovieTicket',
  data () {
    return {
      moviePic: ImageConst.moviePic,
      movie: this.$route.params.movie
    }
  },
  created () {
    this.$router.push({
      path: '/mticket/cinema',
      query: {movieId: this.movie['movie_id']}
    })
  },
  components: {
    Cinema
  }
}
</script>

<style scoped>
.mt-content {
  margin: 0 0 0 2rem;
  overflow: auto;
  height: 100%;
}
.left-content {
  width: 35%;
  height: 100%;
}
.right-content {
  width: 65%;
  height: 100%;
}
.el-breadcrumb {
  margin-top: 15px;
  font-size: 24px!important;
}
.ticket-item {
  margin-top: 1rem;
}
.movie-detail img {
  width: 250px;
  height: 350px;
}
.introduce {
  margin-left: 20px;
  text-align: left;
}
.word_break_line {
  text-align: left;
}
.word_break_line p {
  border-left: 5px red solid;
  padding-left: 1rem;
}
</style>
