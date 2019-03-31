# vote
基于小程序或h5的投票系统
  
## 环境依赖  
> jdk 11  
> maven 3  
> mysql 5.6

## 目录结构描述
<pre>
├── vote-front                      // 前端应用  
│   ├── vote-front-service          // 前端应用业务逻辑层  
│   └── vote-front-controller       // 前端应用业务视图交互层  
├── vote-manager                    // 后台管理  
│   ├── vote-manager-service        // 后台管理业务逻辑层  
│   └── vote-manager-controller     // 后台管理业务视图交互层  
└── vote-persistence                // 项目持久层  
</pre>
