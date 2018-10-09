#### 模块系统

   - 摘选源码中的一个文件

    module java.compiler {
                exports javax.annotation.processing;
                exports javax.lang.model;
                exports javax.lang.model.element;
                exports javax.lang.model.type;
                exports javax.lang.model.util;
                exports javax.tools;
            
                uses javax.tools.DocumentationTool;
                uses javax.tools.JavaCompiler;
            }
    

   - 模块是代码和数据的封装体,不同的组织或者是代码模块分成不同的包进行管理
   根目录下面会有一个module-info.class文件
