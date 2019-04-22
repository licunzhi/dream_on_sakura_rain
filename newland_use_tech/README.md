# improve tech in newland

```javascript
模板渲染

/*页面工具类*/
    const groupUtils = {

        /**
         * 单条模板渲染工具
         *
         * @param id 原生模板id
         * @param data 数据源
         * @param regex 匹配正则(多数不用)
         * @returns {void | string | *}
         */
        template(id, data, regex) {
            const template = $(`script[id=${id}]`).html();
            return template.replace(regex || /\\?\{([^{}]+)\}/g, function (match, name) {
                return (data[name] === undefined) ? '' : data[name];

            });
        },

        /**
         * 多条模板渲染工具
         *
         * @param id 原生模板id
         * @param data 数据源
         * @param regex 匹配正则(多数不用)
         * @returns {void | string | *}
         * @notice 多条渲染工具以来单条工具渲染方法
         */
        templateIterator(id, data, regex) {
            let result = '';
            for (let value of data) {
                result = result + this.template(id, value, regex);
            }
            return result;
        }
    }
```