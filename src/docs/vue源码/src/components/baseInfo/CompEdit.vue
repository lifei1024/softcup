<template>
	<div style='text-align: center;'>
		<h1>修改公司信息</h1>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入公司名称' v-model='compname'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入联系人' v-model='contacts'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入联系电话' v-model='comptel'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入行业' v-model='industry'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入地址' v-model='address'></el-input> </el-col>
		  <el-col :span="12"> <span></span> </el-col>
		</el-row>
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" > <el-button type='primary' @click='saveEdit'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				compname:'',
				contacts:'',
				comptel:'',
				industry:'',
				address:'',
				compid:''
			};
		},
		methods:{
			saveEdit(){
				var url = this.baseUrl+"/baseCompany/update"
				var data = {compid:this.compid,compname:this.compname,contacts:this.contacts,comptel:this.comptel,industry:this.industry,address:this.address};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  this.$message("更新成功");
					  this.$router.push({path:'/CompList'});
				  })
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			// 获取路由传递的对象
			var obj = this.$route.params.row;
			
			this.compid=obj.compid;
			this.compname=obj.compname;
			this.contacts=obj.contacts;
			this.comptel=obj.comptel;
			this.industry=obj.industry;
			this.address=obj.address;
			
		
		}
		
	}
</script>

<style>

</style>
