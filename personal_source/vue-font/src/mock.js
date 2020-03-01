// import some dependence
const Mock = require('mockjs')
// create random obj
const Random = Mock.Random
// create demo data
const basicData = function () {
  let articles = []
  for (let i = 0; i < 10; i++) {
    let simpleArticle = {
      basic_boolean: Random.boolean(5, 5, true) + '',
      basic_natural: Random.natural(0, 100),
      basic_integer: Random.integer(0, 100),
      basic_float: Random.float(0, 100, 0, 17),
      basic_character: Random.character('lower/upper/number/symbol'),
      basic_string: Random.string('壹贰叁肆伍陆柒捌玖拾', 3, 5),
      basic_range: Random.range(1, 10, 3)
    }
    articles.push(simpleArticle)
  }

  return {
    articles: articles
  }
}

const dateData = function () {
  let articles = []
  for (let i = 0; i < 10; i++) {
    let simpleArticle = {
      Date_date: Random.date('yyyy-MM-dd'),
      Date_time: Random.time('HH:mm:ss'),
      Date_datetime: Random.datetime('yyyy-MM-dd HH:mm:ss'),
      Date_now: Random.now('second')
    }
    articles.push(simpleArticle)
  }

  return {
    articles: articles
  }
}

const imageData = function () {
  return {
    imageData: Random.dataImage('800x600', 'Hello Mock.js!')
  }
}

const paragraphData = function () {
  let articles = []
  for (let i = 0; i < 10; i++) {
    let simpleArticle = {
      cparagraph: Random.cparagraph(1, 3),
      sentence: Random.sentence(3, 5),
      cword: Random.cword('零一二三四五六七八九十', 5, 7),
      ctitle: Random.ctitle(3, 5)
    }
    articles.push(simpleArticle)
  }

  return {
    articles: articles
  }
}

// export methods to use
Mock.mock('/basic', 'post', basicData)
Mock.mock('/date', 'post', dateData)
Mock.mock('/image', 'post', imageData)
Mock.mock('/paragraph', 'post', paragraphData)
