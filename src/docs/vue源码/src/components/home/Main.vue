<template>
	<div class="main">
		<!-- Tags标签 -->
		<el-tag v-for="(tag,index) in $store.state.tags" :key="tag.name" closable :type="tag.type" 
			style='margin:10px 15px 20px 0px;' @click='cli(tag,index)' @close='del(tag,index)'> 
			{{tag.name}}
		</el-tag>

		<!-- 视图出口 -->
		<router-view></router-view>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				
			};
		},
		methods:{
			cli(tag,index){
				// 路由跳转
				this.$router.push({path:tag.url});
				// 点击tag时设置tag样式
				this.$store.commit('updateTag',index);
				// 更改Menu.vue中的defaultActive
				this.$store.commit('changeDefaultActive',tag.index);
			},
			del(tag,index){
				// 删除tag
				this.$store.commit('delTag',index);
				if(tag.type=='warning'){
					// 最后一个元素
					if(this.$store.state.tags.length==0){
						this.$store.commit('addTag',{name: '首页', type: 'warning',url:'/',index:'101'});
						this.$router.push({path:'/'});
					}else if(index==0){
						this.$store.commit('updateTag',0);
						this.$router.push({path:this.$store.state.tags[0].url});
					}else{
						this.$store.commit('updateTag',index-1);
						this.$router.push({path:this.$store.state.tags[index-1].url});
					}
				}
				
				
			}
		}
		
	}
</script>

<style>
.main{
	text-align: left;
}
</style>
