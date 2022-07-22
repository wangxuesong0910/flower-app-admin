<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->

		<view v-if="current === 0">
			<u-form :model="putForm" class="apply-form-field">
				<u-gap height="20" bg-color="#f5f5f5"></u-gap>
<!-- 				<u-form-item label="一级分类" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->

				<u-form-item label="三级分类" label-width="130">
					<u-input v-model="detailSelectValue" type="select" @click="detailSelectListOpen"/>
					<!-- <u-action-sheet :list="appDetailSelectList" v-model="appDetailSelectListShow"
						@click="detailSelectCallback1"></u-action-sheet> -->
						<u-select v-model="appDetailSelectListShow" mode="mutil-column-auto" :list="appDetailSelectList"  @confirm="confirm"></u-select>
					<!-- <u-input placeholder="请选择一级分类" v-model="list.name" type="select" class="form-field-select" /> -->
				</u-form-item>
				<!-- <u-gap height="20" bg-color="#f5f5f5"></u-gap>
				<u-form-item label="开始时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item>
				<u-form-item label="结束时间" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->
				<u-form-item label="数量(扎)" label-width="150" >
					<u-input placeholder="请输入" type="input" v-model="putForm.quantity"/>
				</u-form-item>
<!-- 				<u-form-item label="批发方式" label-width="150" right-icon="arrow-right">
					<u-input placeholder="请选择" type="select" class="form-field-select" />
				</u-form-item> -->
				<!-- <u-form-item label="进货价" label-width="150" >
					<u-input placeholder="请输入" type="input" v-model="putForm.buyingPrice"/>
				</u-form-item> -->
				<!-- <u-form-item label="档次:" label-width="130">
					<u-input v-model="value" type="select" @click="gradeListOpen" />
					<u-action-sheet :list="gradeList" v-model="gradeListShow"
						@click="gradeSelectCallback1"></u-action-sheet>
		
				</u-form-item> -->

			</u-form>
			<u-row gutter="32" class="bottom-box" justify="center">
				<u-col span="10">
					<view>
						<u-button type="primary" shape="circle" @click="submitPutForm">确定</u-button>
					</view>
				</u-col>
			</u-row>
		</view>
		<view v-if="current === 1">
			<view class="search">
				<u-search v-model="keyWords" @custom="search" @search="search"></u-search>
			</view>
				
			<u-card v-for="item in logList" :key="item.id" class="task-list-item" :border="false" padding="20"
				margin="20rpx">
				<view slot="head" style="display: flex;align-items: center;justify-content: space-between;">
					<view style="display: flex;align-items: center;font-size: 30rpx;">
						<image class="user-images" src="/static/aidex/images/user06.png"></image>操作人：{{item.createBy}}
					</view>
					<view style="color: #999999;font-size: 22rpx;">{{item.createDatetime}}</view>
				</view>
				<view class="" slot="body">
					<u-row gutter="16">
						<u-col span="12">
							<view class="apply-text"><span>三级分类：</span>{{item.type}}</view>
						</u-col>
						<u-col span="12">
							<view class="apply-text"><span>数量：</span>{{item.num}}</view>
						</u-col>

					</u-row>
				</view>
<!-- 				<view class="apply-list-foot" slot="foot" style="text-align: right;color: #58ca93;">
					<u-button type="primary" size="mini" shape="circle" :ripple="true">修改</u-button>
					<u-button type="error" size="mini" shape="circle" :ripple="true">删除</u-button>
				</view> -->
			</u-card>
			<u-loadmore :status="status" :icon-type="iconType" @loadmore="loadmore()" @onReachBottom="onReachBottom()" :load-text="loadText" />
		</view>
	<u-toast ref="uToast" />
	
	</view>
</template>
<script>
	export default {
		data() {
			return {
				logList: [],
				putForm: {},
				value: '',
				detailSelectValue: '',
				gradeListShow: false,
				appDetailSelectListShow: false,
				show: false,
				list: [{
					name: '批发入库'
				},{
					name: '入库记录'
				},],
				//档次
				gradeList:[{
					text: 'A'
				},{
					text: 'B'
				}],
				//三级分类下拉列表
				appDetailSelectList:[],
				appDetailSelectListTmp:[],
				m2mSimflowList: [],
				m2mOrderFlowList: [],
				current: 0,
				status: 'loadmore',
				iconType: 'circle',
				isDot: false,
				loadText: {
					loadmore: '点击加载更多',
					loading: '正在加载...',
					nomore: '没有更多了'
				},
				dataList: [{
					age: 1,
					name: 'aaa'
				}, {
					age: 2,
					name: 'bbb'
				}, {
					age: 3,
					name: 'ccc'
				}],
				keyWords: '',
				form:{},
				logQueryParams: {
					pageNum: 1,
					        pageSize: 3,
					        storageId: null,
							type: null,
					        inOut: null,
					        num: null,
					        createDatetime: null,
					        outStatus: null,
							createBy: null
				},
				total: 0
			}
		},
		onLoad() {
			this.getAppDetailSelect();
			this.getStorageLogList();
		},
		created() {},
		methods: {
			//上拉触发，加载更多
			onReachBottom() {
				if (this.status != 'nomore') {
					this.status = 'loading'
					this.getStorageLogList();
				}
			},
			//加载更多，点击触发
			loadmore(e) {
			
				this.status = 'loading'
				// this.queryParamsVarieties.pageNum = ++this.queryParamsVarieties.pageNum;
				this.getStorageLogList();
			
			
			},
			getStorageLogList(){
				
				this.logQueryParams.inOut = 'in';
				this.$u.api.put.putLogList(this.logQueryParams).then(res=>{
					for (var i = 0; i < res.rows.length; i++) {
						this.logList.push(res.rows[i])
					}
					if(this.logQueryParams.pageNum == 1){
						this.total = res.total;
					}
					if (this.logQueryParams.pageNum * 3 > this.total) {
						this.status = 'nomore'
					} else {
						
						this.logQueryParams.pageNum = ++this.logQueryParams.pageNum;
						this.status = 'loadmore'	
					}	
				})
				

			},
			submitPutForm(){
				this.$u.api.put.putForm(this.putForm).then(res=>{
					this.putForm = {};
					if(res.data == 1){
						this.$refs.uToast.show({
											title: '入库成功',
											type: 'success',
											url: '/pages/sys/workbench/put/index'
										})
					}else{
						this.$refs.uToast.show({
											title: '入库失败',
											type: 'error',
											url: '/pages/sys/workbench/put/index'
										})
					}
				})
			},
			confirm(e) {
				this.detailSelectValue = e[1].label;
				this.putForm.detailedId = e[1].value;
				console.log(JSON.stringify(this.detailSelectValue));
			},
			getAppDetailSelect(){
				this.$u.api.put.appDetailSelectList({
				}).then(res => {
					// this.appDetailSelectList = res.data;
					for(let key in res.data){
						let tmp = {
							value: key,
							label: key,
							children:res.data[key]
						}
						this.appDetailSelectList.push(tmp);
					}
				})
			},
			// 点击actionSheet回调
			gradeSelectCallback1(index) {
				this.value = this.gradeList[index].text;
			},
			// 点击actionSheet回调
			detailSelectCallback1(index) {
				this.detailSelectValue = this.appDetailSelectList[index].text;
			},
			gradeListOpen(){
				this.gradeListShow = true;
			},
			detailSelectListOpen(){
				this.appDetailSelectListShow = true;
			},
			change(index) {
				this.current = index;
			},
			navTo(url) {
				uni.navigateTo({
					url: url
				});
			}
		}

	}
</script>
<style lang="scss" scoped>
	@import '../index.scss';

	page {
		background-color: #f5f5f5;
	}

	.wrap .search {
		background: #ffffff;
	}

	.apply-text {
		font-size: 28rpx;
		color: #333333;

		span {
			color: #999999;
		}
	}

	.user-images {
		width: 28px;
		height: 28px;
		margin-right: 8px;
	}

	.apply-list-foot {
		font-size: 28rpx;
	}

	.personnel-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;

		.personnel-user {
			position: relative;
			margin: 5px 9px 0;
		}

		.user-images {
			width: 48px;
			height: 48px;
			margin-right: 0;

		}

		.iconfont {
			position: absolute;
			top: -12px;
			right: -5px;
			color: #FE0100;
		}
	}
</style>
