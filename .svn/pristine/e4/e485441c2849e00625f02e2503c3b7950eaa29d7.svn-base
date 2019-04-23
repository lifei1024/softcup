<template>
	<div>
		<span>请选择年份：</span> <el-date-picker v-model="year"  type="year"
			placeholder="请选择年份" value-format='yyyy'>
		  </el-date-picker>
		  <el-button @click='search()'>查询</el-button>
		<h1>流程能耗对比图-折标煤</h1>
		<ve-line :data="chartData"></ve-line>
		<h1>设备类别能耗对比图-折标煤</h1>
		<ve-histogram :data="chartData2"></ve-histogram>
		<h1>设备能耗对比图-折标煤</h1>
		<ve-line :data="chartData3"></ve-line>
		<h1>设备单位作业量耗电量对比图</h1>
		<ve-line :data="chartData4"></ve-line>
		<h1>设备单位作业量耗水量对比图</h1>
		<ve-line :data="chartData5"></ve-line>
		<h1>设备单位作业量耗油量对比图</h1>
		<ve-line :data="chartData6"></ve-line>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				year:'2018',
				chartData: {},
				chartData2: {},
				chartData3: {},
				chartData4: {},
				chartData5: {},
				chartData6: {},
			};
		},
		methods:{
			search(){
				// 后端网址
				var url = this.baseUrl+"/energyConsume/flowConsume"
				// 传递给后端的数据
				var data = {year:this.year};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.chartData = res.data;
				  })
				  
				  
				 // 后端网址
				  var url2 = this.baseUrl+"/energyConsume/devTypeConsume"
				  // 传递给后端的数据
				  var data = {year:this.year};
				  this.$axios.post(url2,this.$qs.stringify(data),{
				  	headers: {
				  		'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				  	  }
				    }).then(res=>{
				  	  // res是后端的响应
				  	  this.chartData2 = res.data;
				    })
					
				  // 后端网址
				  var url3 = this.baseUrl+"/energyConsume/devConsume"
				  // 传递给后端的数据
				  var data = {year:this.year};
				  this.$axios.post(url3,this.$qs.stringify(data),{
				  	headers: {
				  		'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				  	  }
				    }).then(res=>{
				  	  // res是后端的响应
				  	  this.chartData3 = res.data;
				    })
					
					// 后端网址
					var url4 = this.baseUrl+"/energyConsume/electricConsume"
					// 传递给后端的数据
					var data = {year:this.year};
					this.$axios.post(url4,this.$qs.stringify(data),{
						headers: {
							'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
						  }
					  }).then(res=>{
						  // res是后端的响应
						  this.chartData4 = res.data;
					  })
					  
					  // 后端网址
					  var url5 = this.baseUrl+"/energyConsume/waterConsume"
					  // 传递给后端的数据
					  var data = {year:this.year};
					  this.$axios.post(url5,this.$qs.stringify(data),{
					  	headers: {
					  		'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  	  }
					    }).then(res=>{
					  	  // res是后端的响应
					  	  this.chartData5 = res.data;
					    })
						
					// 后端网址
					var url6 = this.baseUrl+"/energyConsume/oilConsume"
					// 传递给后端的数据
					var data = {year:this.year};
					this.$axios.post(url6,this.$qs.stringify(data),{
						headers: {
							'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
						  }
					  }).then(res=>{
						  // res是后端的响应
						  this.chartData6 = res.data;
					  })
			}
		},
		mounted(){
			this.search();
		}
		
	}
</script>

<style>
h1{
	text-align: center;
}
</style>
