import request from '@/utils/request'

// 查询鲜花的仓储信息单列表
export function listStorage(query) {
  return request({
    url: '/erp/storage/list',
    method: 'get',
    params: query
  })
}

// 查询鲜花的仓储信息单详细
export function getStorage(id) {
  return request({
    url: '/erp/storage/' + id,
    method: 'get'
  })
}

// 新增鲜花的仓储信息单
export function addStorage(data) {
  return request({
    url: '/erp/storage',
    method: 'post',
    data: data
  })
}

// 修改鲜花的仓储信息单
export function updateStorage(data) {
  return request({
    url: '/erp/storage',
    method: 'put',
    data: data
  })
}

// 删除鲜花的仓储信息单
export function delStorage(id) {
  return request({
    url: '/erp/storage/' + id,
    method: 'delete'
  })
}

