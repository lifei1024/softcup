<template>
	<div>
		<el-button @click='fn1'>佩奇</el-button>
		<el-button @click='fn2'>乔治</el-button>
		<router-view></router-view>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		},
		methods:{
			fn1(){
				this.$router.push({path:'/pig/pig1'});
			},
			fn2(){
				this.$router.push({path:'/pig/pig2'});
			}
		}
	}
</script>

<style>

</style>
