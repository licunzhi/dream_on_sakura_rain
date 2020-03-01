const barOneOne = {
  title: {
    text: ''
  },
  legend: {
    data: ['bar', 'bar2'],
    align: 'left'
  },
  toolbox: {
    // y: 'bottom',
    feature: {
      magicType: {
        type: ['stack', 'tiled']
      },
      dataView: {},
      saveAsImage: {
        pixelRatio: 2
      }
    }
  },
  tooltip: {},
  xAxis: {
    data: [],
    silent: false,
    splitLine: {
      show: false
    }
  },
  yAxis: {},
  series: [{
    name: 'bar',
    type: 'bar',
    data: [],
    animationDelay: function (idx) {
      return idx * 10
    }
  }, {
    name: 'bar2',
    type: 'bar',
    data: [],
    animationDelay: function (idx) {
      return idx * 10 + 100
    }
  }],
  animationEasing: 'elasticOut',
  animationDelayUpdate: function (idx) {
    return idx * 5
  }
}

export default {barOneOne}
