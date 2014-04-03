(function(window) {
    
    if(window.PrimeFaces) {
        PrimeFaces.debug("PrimeFaces already loaded, ignoring duplicate execution.");
        return;
    }
    
    var PrimeFaces = {

        escapeClientId : function(id) {
            return "#" + id.replace(/:/g,"\\:");
        },

        cleanWatermarks : function(){
            $.watermark.hideAll();
        },

        showWatermarks : function(){
            $.watermark.showAll();
        },

        addSubmitParam : function(parent, params) {
            var form = $(this.escapeClientId(parent));

            for(var key in params) {
                form.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + params[key] + "\" class=\"ui-submit-param\"/>");
            }

            return this;
        },

        /**
         * Submits a form and clears ui-submit-param after that to prevent dom caching issues
         */ 
        submit : function(formId, target) {
            var form = $(this.escapeClientId(formId));
            if(target) {
                form.attr('target', target);
            }
            
            form.submit().children('input.ui-submit-param').remove();
        },

        attachBehaviors : function(element, behaviors) {
            $.each(behaviors, function(event, fn) {
                element.bind(event, function(e) {
                    fn.call(element, e);
                });
            });
        },

        getCookie : function(name) {
            return $.cookie(name);
        },

        setCookie : function(name, value) {
            $.cookie(name, value);
        },
                
        cookiesEnabled: function() {
            var cookieEnabled = (navigator.cookieEnabled) ? true : false;

            if(typeof navigator.cookieEnabled === 'undefined' && !cookieEnabled) { 
                document.cookie="testcookie";
                cookieEnabled = (document.cookie.indexOf("testcookie") !== -1) ? true : false;
            }
            
            return (cookieEnabled);
        },

        skinInput : function(input) {
            input.hover(
                function() {
                    $(this).addClass('ui-state-hover');
                },
                function() {
                    $(this).removeClass('ui-state-hover');
                }
            ).focus(function() {
                $(this).addClass('ui-state-focus');
            }).blur(function() {
                $(this).removeClass('ui-state-focus');
            });

            //aria
            input.attr('role', 'textbox')
                    .attr('aria-disabled', input.is(':disabled'))
                    .attr('aria-readonly', input.prop('readonly'));
    
            if(input.is('textarea')) {
                input.attr('aria-multiline', true);
            }

            return this;
        },

        skinButton : function(button) {
            button.mouseover(function(){
                var el = $(this);
                if(!button.prop('disabled')) {
                    el.addClass('ui-state-hover');
                }
            }).mouseout(function() {
                $(this).removeClass('ui-state-active ui-state-hover');
            }).mousedown(function() {
                var el = $(this);
                if(!button.prop('disabled')) {
                    el.addClass('ui-state-active').removeClass('ui-state-hover');
                }
            }).mouseup(function() {
                $(this).removeClass('ui-state-active').addClass('ui-state-hover');
            }).focus(function() {
                $(this).addClass('ui-state-focus');
            }).blur(function() {
                $(this).removeClass('ui-state-focus ui-state-active');
            }).keydown(function(e) {
                if(e.keyCode === $.ui.keyCode.SPACE || e.keyCode === $.ui.keyCode.ENTER || e.keyCode === $.ui.keyCode.NUMPAD_ENTER) {
                    $(this).addClass('ui-state-active');
                }
            }).keyup(function() {
                $(this).removeClass('ui-state-active');
            });

            //aria
            button.attr('role', 'button').attr('aria-disabled', button.prop('disabled'));

            return this;
        },

        skinSelect : function(select) {
            select.mouseover(function() {
                var el = $(this);
                if(!el.hasClass('ui-state-focus'))
                    el.addClass('ui-state-hover'); 
            }).mouseout(function() {
                $(this).removeClass('ui-state-hover'); 
            }).focus(function() {
                $(this).addClass('ui-state-focus').removeClass('ui-state-hover');
            }).blur(function() {
                $(this).removeClass('ui-state-focus ui-state-hover'); 
            });

            return this;
        },

        isIE: function(version) {
            return (version === undefined) ? this.browser.msie: (this.browser.msie && parseInt(this.browser.version, 10) === version);
        },

        info: function(log) {
            if(this.logger) {
                this.logger.info(log);
            }
        },

        debug: function(log) {
            if(this.logger) {
                this.logger.debug(log);
            }
        },

        warn: function(log) {
            if(this.logger) {
                this.logger.warn(log);
            }
        },

        error: function(log) {
            if(this.logger) {
                this.logger.error(log);
            }
        },

        setCaretToEnd: function(element) {
            if(element) {
                element.focus();
                var length = element.value.length;

                if(length > 0) {
                    if(element.setSelectionRange) {
                        element.setSelectionRange(0, length);
                    } 
                    else if (element.createTextRange) {
                      var range = element.createTextRange();
                      range.collapse(true);
                      range.moveEnd('character', 1);
                      range.moveStart('character', 1);
                      range.select();
                    }
                }
            }
        },

        changeTheme: function(newTheme) {
            if(newTheme && newTheme !== '') {
                var themeLink = $('link[href*="javax.faces.resource/theme.css"]'),
                themeURL = themeLink.attr('href'),
                plainURL = themeURL.split('&')[0],
                oldTheme = plainURL.split('ln=')[1],
                newThemeURL = themeURL.replace(oldTheme, 'primefaces-' + newTheme);

                themeLink.attr('href', newThemeURL);
            }
        },

        escapeRegExp: function(text) {
            return text.replace(/([.?*+^$[\]\\(){}|-])/g, "\\$1");
        },

        escapeHTML: function(value) {
            return value.replace(/&/g,'&amp;').replace(/</g,'&lt;').replace(/>/g,'&gt;');
        },

        clearSelection: function() {
            if(window.getSelection) {
                if(window.getSelection().empty) {
                    window.getSelection().empty();
                } else if(window.getSelection().removeAllRanges) {
                    window.getSelection().removeAllRanges();
                }
            } 
            else if(document.selection && document.selection.empty) {
                try {
                    document.selection.empty();
                } catch(error) {
                    //ignore IE bug
                }
            }
        },
        
        getSelection: function() {
            var text = '';
            if (window.getSelection) {
                text = window.getSelection();
            } else if (document.getSelection) {
                text = document.getSelection();
            } else if (document.selection) {
                text = document.selection.createRange().text;
            }
            
            return text;
        },
        
        hasSelection: function() {
            return this.getSelection().length > 0;
        },

        cw : function(widgetConstructor, widgetVar, cfg, resource) {
            PrimeFaces.createWidget(widgetConstructor, widgetVar, cfg, resource);
        },

        createWidget : function(widgetConstructor, widgetVar, cfg, resource) { 
            if(PrimeFaces.widget[widgetConstructor]) {
                if(PrimeFaces.widgets[widgetVar]) {
                    PrimeFaces.widgets[widgetVar].refresh(cfg);                                     //ajax update
                }
                else {
                    PrimeFaces.widgets[widgetVar] = new PrimeFaces.widget[widgetConstructor](cfg);  //page init
                }
            }
            else {
                var scriptURI = $('script[src*="/javax.faces.resource/primefaces.js"]').attr('src').replace('primefaces.js', resource + '/' + resource + '.js'),
                cssURI = $('link[href*="/javax.faces.resource/primefaces.css"]').attr('href').replace('primefaces.css', resource + '/' + resource + '.css'),
                cssResource = '<link type="text/css" rel="stylesheet" href="' + cssURI + '" />';

                //load css
                $('head').append(cssResource);

                //load script and initialize widget
                PrimeFaces.getScript(location.protocol + '//' + location.host + scriptURI, function() {
                    setTimeout(function() {
                        PrimeFaces.widgets[widgetVar] = new PrimeFaces.widget[widgetConstructor](cfg);
                    }, 100);
                });
            }
        },

        inArray: function(arr, item) {
            for(var i = 0; i < arr.length; i++) {
                if(arr[i] === item) {
                    return true;
                }
            }

            return false;
        },

        isNumber: function(value) {
            return typeof value === 'number' && isFinite(value);
        },

        getScript: function(url, callback) {
            $.ajax({
                type: "GET",
                url: url,
                success: callback,
                dataType: "script",
                cache: true
            });
        },

        focus : function(id, context) {
            var selector = ':not(:submit):not(:button):input:visible:enabled';

            setTimeout(function() {
                if(id) {
                    var jq = $(PrimeFaces.escapeClientId(id));

                    if(jq.is(selector)) {
                        jq.focus();
                    } 
                    else {
                        jq.find(selector).eq(0).focus();
                    }
                }
                else if(context) {
                    $(PrimeFaces.escapeClientId(context)).find(selector).eq(0).focus();
                }
                else {
                    $(selector).eq(0).focus();
                }
            }, 250);

            // remember that a custom focus has been rendered
            // this avoids to retain the last focus after ajax update
            PrimeFaces.customFocus = true;
        },

        monitorDownload: function(start, complete) {
            if(this.cookiesEnabled()) {
                if(start) {
                    start();
                }

                window.downloadMonitor = setInterval(function() {
                    var downloadComplete = PrimeFaces.getCookie('primefaces.download');

                    if(downloadComplete === 'true') {
                        if(complete) {
                            complete();
                        }
                        clearInterval(window.downloadMonitor);
                        PrimeFaces.setCookie('primefaces.download', null);
                    }
                }, 250);
            }
        },

        /**
         *  Scrolls to a component with given client id
         */
        scrollTo: function(id) {
            var offset = $(PrimeFaces.escapeClientId(id)).offset();

            $('html,body').animate({
                scrollTop:offset.top
                ,
                scrollLeft:offset.left
            },{
                easing: 'easeInCirc'
            },1000);

        },

        /**
         *  Aligns container scrollbar to keep item in container viewport, algorithm copied from jquery-ui menu widget
         */
        scrollInView: function(container, item) { 
            if(item.length === 0) {
                return;
            }

            var borderTop = parseFloat(container.css('borderTopWidth')) || 0,
            paddingTop = parseFloat(container.css('paddingTop')) || 0,
            offset = item.offset().top - container.offset().top - borderTop - paddingTop,
            scroll = container.scrollTop(),
            elementHeight = container.height(),
            itemHeight = item.outerHeight(true);

            if(offset < 0) {
                container.scrollTop(scroll + offset);
            }
            else if((offset + itemHeight) > elementHeight) {
                container.scrollTop(scroll + offset - elementHeight + itemHeight);
            }
        },
        
        calculateScrollbarWidth: function() {
            if(!this.scrollbarWidth) {
                if(this.browser.msie) {
                    var $textarea1 = $('<textarea cols="10" rows="2"></textarea>')
                            .css({ position: 'absolute', top: -1000, left: -1000 }).appendTo('body'),
                        $textarea2 = $('<textarea cols="10" rows="2" style="overflow: hidden;"></textarea>')
                            .css({ position: 'absolute', top: -1000, left: -1000 }).appendTo('body');
                    this.scrollbarWidth = $textarea1.width() - $textarea2.width();
                    $textarea1.add($textarea2).remove();
                } 
                else {
                    var $div = $('<div />')
                        .css({ width: 100, height: 100, overflow: 'auto', position: 'absolute', top: -1000, left: -1000 })
                        .prependTo('body').append('<div />').find('div')
                            .css({ width: '100%', height: 200 });
                    this.scrollbarWidth = 100 - $div.width();
                    $div.parent().remove();
                }
            }

            return this.scrollbarWidth;
        },
        
        //adapted from jquery browser plugin
        resolveUserAgent: function(ua) {
            if($.browser) {
                this.browser = $.browser;
            }
            else {
                ua = ua.toLowerCase();

                var match = /(chrome)[ \/]([\w.]+)/.exec(ua) ||
                    /(webkit)[ \/]([\w.]+)/.exec(ua) ||
                    /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(ua) ||
                    /(msie) ([\w.]+)/.exec(ua) ||
                    ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(ua) || [],
                userAgent =  {
                    browser: match[ 1 ] || "",
                    version: match[ 2 ] || "0"
                },
                browser = {};

                if(userAgent.browser) {
                    browser[userAgent.browser] = true;
                    browser.version = userAgent.version;
                }

                if (browser.chrome) {
                    browser.webkit = true;
                } else if (browser.webkit) {
                    browser.safari = true;
                }

                this.browser = browser;
            }
        },

        bcn: function(element, event, functions) {
            if(functions) {
                for(var i = 0; i < functions.length; i++) {
                    var retVal = functions[i].call(element, event);
                    if(retVal === false) {
                        if(event.preventDefault) {
                            event.preventDefault();
                        }
                        else {
                            event.returnValue = false;
                        }

                        break;
                    }
                } 
            }
        },
        
    	/**
    	 * moved to core.dialog.js
    	 */
        openDialog: function(cfg) {
        	PrimeFaces.dialog.DialogHandler.openDialog(cfg);
        },
        closeDialog: function(cfg) {
        	PrimeFaces.dialog.DialogHandler.closeDialog(cfg);
        },      
        showMessageInDialog: function(msg) {
        	PrimeFaces.dialog.DialogHandler.showMessageInDialog(msg);
        },        
        confirm: function(msg) {
        	PrimeFaces.dialog.DialogHandler.confirm(msg);
        },
    	
        zindex : 1000,
        
        customFocus : false,
        
        detachedWidgets : [],

        PARTIAL_REQUEST_PARAM : "javax.faces.partial.ajax",

        PARTIAL_UPDATE_PARAM : "javax.faces.partial.render",

        PARTIAL_PROCESS_PARAM : "javax.faces.partial.execute",

        PARTIAL_SOURCE_PARAM : "javax.faces.source",

        BEHAVIOR_EVENT_PARAM : "javax.faces.behavior.event",

        PARTIAL_EVENT_PARAM : "javax.faces.partial.event",
        
        RESET_VALUES_PARAM : "primefaces.resetvalues",
        
        IGNORE_AUTO_UPDATE_PARAM : "primefaces.ignoreautoupdate",

        VIEW_STATE : "javax.faces.ViewState",
        
        CLIENT_WINDOW : "javax.faces.ClientWindow",

        VIEW_ROOT : "javax.faces.ViewRoot",

        CLIENT_ID_DATA : "primefaces.clientid"
    };
    
    /**
     * PrimeFaces Namespaces
     */
    PrimeFaces.settings = {};
    PrimeFaces.util = {};
    PrimeFaces.widgets = {};
    
    /**
     * Locales
     */
    PrimeFaces.locales = {
        
        'en_US': {
            closeText: 'Close',
            prevText: 'Previous',
            nextText: 'Next',
            monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December' ],
            monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ],
            dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
            dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Tue', 'Fri', 'Sat'],
            dayNamesMin: ['S', 'M', 'T', 'W ', 'T', 'F ', 'S'],
            weekHeader: 'Week',
            firstDay: 0,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix:'',
            timeOnlyTitle: 'Only Time',
            timeText: 'Time',
            hourText: 'Time',
            minuteText: 'Minute',
            secondText: 'Second',
            currentText: 'Current Date',
            ampm: false,
            month: 'Month',
            week: 'week',
            day: 'Day',
            allDayText: 'All Day'
        }
        
    };
    
    PF = function(widgetVar) {    	
    	var widgetInstance = PrimeFaces.widgets[widgetVar];
    	
    	if (!widgetInstance) {
	        if (window.console && console.log) { 
	            console.log("Widget for var '" + widgetVar + "' not available!");
	        }
	        
	        PrimeFaces.error("Widget for var '" + widgetVar + "' not available!");
    	}
    	
        return widgetInstance;
    };
    
    PrimeFaces.resolveUserAgent(navigator.userAgent);
   
    //expose globally
    window.PrimeFaces = PrimeFaces;

})(window);
/**
 * AJAX parameter shortcut mapping for PrimeFaces.ab
 */
PrimeFaces.AB_MAPPING = { 
    's': 'source',
    'f': 'formId',
    'p': 'process',
    'u': 'update',
    'e': 'event',
    'a': 'async',
    'g': 'global',
    'd': 'delay',
    'iau': 'ignoreAutoUpdate',
    'ps': 'partialSubmit',
    'rv': 'resetValues',
    'fi': 'fragmentId',
    'fu': 'fragmentUpdate',
    'pa': 'params',
    'onst': 'onstart',
    'oner': 'onerror',
    'onsu': 'onsuccess',
    'onco': 'oncomplete'
};

/**
 * Ajax shortcut
 */
PrimeFaces.ab = function(cfg, ext) {
    for (var option in cfg) {
        if (!cfg.hasOwnProperty(option)) {
            continue;
        }
        
        // just pass though if no mapping is available
        if (this.AB_MAPPING[option]) {
            cfg[this.AB_MAPPING[option]] = cfg[option];
            delete cfg[option];
        }
    }
    
    PrimeFaces.ajax.Request.handle(cfg, ext);
};

PrimeFaces.ajax = {
    
    VIEW_HEAD : "javax.faces.ViewHead",
    VIEW_BODY : "javax.faces.ViewBody",
    
    Utils: {
 
        getContent: function(node) {
            var content = '';

            for(var i = 0; i < node.childNodes.length; i++) {
                content += node.childNodes[i].nodeValue;
            }

            return content;
        },

        updateFormStateInput: function(name, value, xhr) {
            var trimmedValue = $.trim(value);

            var forms = null;
            if (xhr && xhr.pfSettings && xhr.pfSettings.portletForms) {
                forms = $(xhr.pfSettings.portletForms);
            }
            else {
                forms = $('form');
            }
            
            for (var i = 0; i < forms.length; i++) {
                var form = forms.eq(i);

                if (form.attr('method') === 'post') {
                    var input = form.children("input[name='" + name + "']");

                    if (input.length > 0) {
                        input.val(trimmedValue);
                    } else {
                        form.append('<input type="hidden" name="' + name + '" value="' + trimmedValue + '" autocomplete="off" />');
                    }
                }
            }
        },

        updateElement: function(id, content, xhr) {
            if (id.indexOf(PrimeFaces.VIEW_STATE) !== -1) {
                PrimeFaces.ajax.Utils.updateFormStateInput(PrimeFaces.VIEW_STATE, content, xhr);
            }
            else if (id.indexOf(PrimeFaces.CLIENT_WINDOW) !== -1) {
                PrimeFaces.ajax.Utils.updateFormStateInput(PrimeFaces.CLIENT_WINDOW, content, xhr);
            }
            else if (id === PrimeFaces.VIEW_ROOT) {
                // reset PrimeFaces JS state
                window.PrimeFaces = null;
                
                var cache = $.ajaxSetup()['cache'];
                $.ajaxSetup()['cache'] = true;
                $('head').html(content.substring(content.indexOf("<head>") + 6, content.lastIndexOf("</head>")));
                $.ajaxSetup()['cache'] = cache;

                var bodyStartTag = new RegExp("<body[^>]*>", "gi").exec(content)[0];
                var bodyStartIndex = content.indexOf(bodyStartTag) + bodyStartTag.length;
                $('body').html(content.substring(bodyStartIndex, content.lastIndexOf("</body>")));
            }
            else if (id === PrimeFaces.ajax.VIEW_HEAD) {
                // reset PrimeFaces JS state
                window.PrimeFaces = null;
                
                var cache = $.ajaxSetup()['cache'];
                $.ajaxSetup()['cache'] = true;
                $('head').html(content.substring(content.indexOf("<head>") + 6, content.lastIndexOf("</head>")));
                $.ajaxSetup()['cache'] = cache;
            }
            else if (id === PrimeFaces.ajax.VIEW_BODY) {
                var bodyStartTag = new RegExp("<body[^>]*>", "gi").exec(content)[0];
                var bodyStartIndex = content.indexOf(bodyStartTag) + bodyStartTag.length;
                $('body').html(content.substring(bodyStartIndex, content.lastIndexOf("</body>")));
            }
            else {
                $(PrimeFaces.escapeClientId(id)).replaceWith(content);
            }
        }
    },
    
    Queue: {

        delayHandler : null,

        requests : new Array(),

        offer : function(request) {
            if (this.delayHandler) {
                clearTimeout(this.delayHandler);
                this.delayHandler = null;
            }

            if (request.delay && request.delay > 0) {
                var $this = this;

                this.delayHandler = setTimeout(function() {
                    $this.requests.push(request);

                    if($this.requests.length === 1) {
                        PrimeFaces.ajax.Request.send(request);
                    }
                }, request.delay);

            } else {

                this.requests.push(request);

                if(this.requests.length === 1) {
                    PrimeFaces.ajax.Request.send(request);
                }
            }
        },

        poll : function() {
            if(this.isEmpty()) {
                return null;
            }

            var processed = this.requests.shift(),
            next = this.peek();

            if(next) {
                PrimeFaces.ajax.Request.send(next);
            }

            return processed;
        },

        peek : function() {
            if(this.isEmpty()) {
                return null;
            }

            return this.requests[0];
        },

        isEmpty : function() {
            return this.requests.length === 0;
        }
    },
    
    Request: {

        handle: function(cfg, ext) {
            cfg.ext = ext;

            if(cfg.async) {
                PrimeFaces.ajax.Request.send(cfg);
            }
            else {
                PrimeFaces.ajax.Queue.offer(cfg);
            }
        },

        send: function(cfg) {
            PrimeFaces.debug('Initiating ajax request.');

            PrimeFaces.customFocus = false;

            var global = (cfg.global === true || cfg.global === undefined) ? true : false,
            form = null,
            sourceId = null;

            if(cfg.onstart) {
                var retVal = cfg.onstart.call(this, cfg);
                if(retVal === false) {
                    PrimeFaces.debug('Ajax request cancelled by onstart callback.');

                    //remove from queue
                    if(!cfg.async) {
                        PrimeFaces.ajax.Queue.poll();
                    }

                    return false;  //cancel request
                }
            }

            if(global) {
                $(document).trigger('pfAjaxStart');
            }

            //source can be a client id or an element defined by this keyword
            if(typeof(cfg.source) === 'string') {
                sourceId = cfg.source;
            } else {
                sourceId = $(cfg.source).attr('id');
            }

            if(cfg.formId) {
                //Explicit form is defined
                form = $(PrimeFaces.escapeClientId(cfg.formId));
            }
            else {
                //look for a parent of source
                form = $(PrimeFaces.escapeClientId(sourceId)).parents('form:first');

                //source has no parent form so use first form in document
                if (form.length === 0) {
                    form = $('form').eq(0);
                }
            }

            PrimeFaces.debug('Form to post ' + form.attr('id') + '.');

            var postURL = form.attr('action'),
            encodedURLfield = form.children("input[name='javax.faces.encodedURL']"),
            postParams = [];

            //portlet support
            var porletFormsSelector = null;
            if(encodedURLfield.length > 0) {
                porletFormsSelector = 'form[action="' + postURL + '"]';
                postURL = encodedURLfield.val();
            }

            PrimeFaces.debug('URL to post ' + postURL + '.');

            //partial ajax
            postParams.push({
                name:PrimeFaces.PARTIAL_REQUEST_PARAM, 
                value:true
            });

            //source
            postParams.push({
                name:PrimeFaces.PARTIAL_SOURCE_PARAM, 
                value:sourceId
            });

            //resetValues
            if (cfg.resetValues) {
                postParams.push({
                    name:PrimeFaces.RESET_VALUES_PARAM, 
                    value:true
                });
            }

            //ignoreAutoUpdate
            if (cfg.ignoreAutoUpdate) {
                postParams.push({
                    name:PrimeFaces.IGNORE_AUTO_UPDATE_PARAM, 
                    value:true
                });
            }

            //process
            var processArray = PrimeFaces.ajax.Request.resolveComponentsForAjaxCall(cfg, 'process');
            if(cfg.fragmentId) {
                processArray.push(cfg.fragmentId);
            }
            var processIds = processArray.length > 0 ? processArray.join(' ') : '@all';
            if (processIds !== '@none') {
                postParams.push({
                    name:PrimeFaces.PARTIAL_PROCESS_PARAM, 
                    value:processIds
                });
            }

            //update
            var updateArray = PrimeFaces.ajax.Request.resolveComponentsForAjaxCall(cfg, 'update');
            if(cfg.fragmentId && cfg.fragmentUpdate) {
                updateArray.push(cfg.fragmentId);
            }
            if(updateArray.length > 0) {
                postParams.push({
                    name:PrimeFaces.PARTIAL_UPDATE_PARAM, 
                    value:updateArray.join(' ')
                });
            }

            //behavior event
            if(cfg.event) {
                postParams.push({
                    name:PrimeFaces.BEHAVIOR_EVENT_PARAM, 
                    value:cfg.event
                });

                var domEvent = cfg.event;

                if(cfg.event === 'valueChange')
                    domEvent = 'change';
                else if(cfg.event === 'action')
                    domEvent = 'click';

                postParams.push({
                    name:PrimeFaces.PARTIAL_EVENT_PARAM, 
                    value:domEvent
                });
            } 
            else {
                postParams.push({
                    name:sourceId, 
                    value:sourceId
                });
            }

            //params
            if(cfg.params) {
                $.merge(postParams, cfg.params);
            }
            if(cfg.ext && cfg.ext.params) {
                $.merge(postParams, cfg.ext.params);
            }

            /**
             * Only add params of process components and their children 
             * if partial submit is enabled and there are components to process partially
             */
            if(cfg.partialSubmit && processIds.indexOf('@all') === -1) {
                var formProcessed = false;

                if(processIds.indexOf('@none') === -1) {
                    for (var i = 0; i < processArray.length; i++) {
                        var jqProcess = $(PrimeFaces.escapeClientId(processArray[i]));
                        var componentPostParams = null;

                        if(jqProcess.is('form')) {
                            componentPostParams = jqProcess.serializeArray();
                            formProcessed = true;
                        }
                        else if(jqProcess.is(':input')) {
                            componentPostParams = jqProcess.serializeArray();
                        }
                        else {
                            componentPostParams = jqProcess.find(':input').serializeArray();
                        }

                        $.merge(postParams, componentPostParams);
                    }
                }

                //add form state if necessary
                if(!formProcessed) {
                    postParams.push({
                        name:PrimeFaces.VIEW_STATE, 
                        value:form.children("input[name='" + PrimeFaces.VIEW_STATE + "']").val()
                    });

                    var clientWindowInput = form.children("input[name='" + PrimeFaces.CLIENT_WINDOW + "']");
                    if (clientWindowInput.length > 0) {
                        postParams.push({ name:PrimeFaces.CLIENT_WINDOW, value:clientWindowInput.val() });
                    }
                    
                    var dsClientWindowInput = form.children("input[name='dsPostWindowId']");
                    if (dsClientWindowInput.length > 0) {
                        postParams.push({ name:'dsPostWindowId', value:dsClientWindowInput.val() });
                    }
                    
                }

            }
            else {
                $.merge(postParams, form.serializeArray());
            }

            //serialize
            var postData = $.param(postParams);

            PrimeFaces.debug('Post Data:' + postData);

            var xhrOptions = {
                url : postURL,
                type : "POST",
                cache : false,
                dataType : "xml",
                data : postData,
                portletForms: porletFormsSelector,
                source: cfg.source,
                global: false,
                beforeSend: function(xhr, settings) {
                    xhr.setRequestHeader('Faces-Request', 'partial/ajax');
                    xhr.pfSettings = settings;
                    xhr.pfArgs = {}; // default should be an empty object

                    if(global) {
                        $(document).trigger('pfAjaxSend', [xhr, this]);
                    }       
                },
                error: function(xhr, status, errorThrown) {                    
                    if(cfg.onerror) {
                        cfg.onerror.call(this, [xhr, status, errorThrown]);
                    }

                    if(global) {
                        $(document).trigger('pfAjaxError', xhr, this, errorThrown);
                    }

                    PrimeFaces.error('Request return with error:' + status + '.');
                },
                success: function(data, status, xhr) {
                    PrimeFaces.debug('Response received succesfully.');

                    var parsed;

                    //call user callback
                    if(cfg.onsuccess) {
                        parsed = cfg.onsuccess.call(this, data, status, xhr);
                    }

                    //extension callback that might parse response
                    if(cfg.ext && cfg.ext.onsuccess && !parsed) {
                        parsed = cfg.ext.onsuccess.call(this, data, status, xhr); 
                    }

                    if(global) {
                        $(document).trigger('pfAjaxSuccess', [xhr, this]);
                    }

                    //do not execute default handler as response already has been parsed
                    if(parsed) {
                        return;
                    } 
                    else {
                        PrimeFaces.ajax.Response.handle(data, status, xhr);
                    }

                    PrimeFaces.debug('DOM is updated.');
                },
                complete: function(xhr, status) {
                    if(cfg.oncomplete) {
                        cfg.oncomplete.call(this, xhr, status, xhr.pfArgs);
                    }

                    if(cfg.ext && cfg.ext.oncomplete) {
                        cfg.ext.oncomplete.call(this, xhr, status, xhr.pfArgs);
                    }

                    if(global) {
                        $(document).trigger('pfAjaxComplete', [xhr, this]);
                    }

                    PrimeFaces.debug('Response completed.');

                    if(!cfg.async) {
                        PrimeFaces.ajax.Queue.poll();
                    }
                }
            };

            $.ajax(xhrOptions);
        },

        resolveComponentsForAjaxCall: function(cfg, type) {

            var expressions = '';

            if (cfg[type]) {
                expressions += cfg[type];
            }

            if (cfg.ext && cfg.ext[type]) {
                expressions += " " + cfg.ext[type];
            }

            return PrimeFaces.expressions.SearchExpressionFacade.resolveComponents(expressions);
        }
    },
    
    Response: {
        
        handle: function(xml, status, xhr, updateHandler) {
            var partialResponseNode = xml.getElementsByTagName("partial-response")[0];

            for (var i = 0; i < partialResponseNode.childNodes.length; i++) {
                var currentNode = partialResponseNode.childNodes[i];
                
                switch (currentNode.nodeName) {
                    case "redirect":
                        PrimeFaces.ajax.ResponseProcessor.doRedirect(currentNode);
                        break;

                    case "changes":
                        for (var j = 0; j < currentNode.childNodes.length; j++) {
                            var currentChangeNode = currentNode.childNodes[j];
                            switch (currentChangeNode.nodeName) {
                                case "update":
                                    PrimeFaces.ajax.ResponseProcessor.doUpdate(currentChangeNode, xhr, updateHandler);
                                    break;
                                case "delete":
                                    PrimeFaces.ajax.ResponseProcessor.doDelete(currentChangeNode);
                                    break;
                                case "insert":
                                    PrimeFaces.ajax.ResponseProcessor.doInsert(currentChangeNode);
                                    break;
                                case "attributes":
                                    PrimeFaces.ajax.ResponseProcessor.doAttributes(currentChangeNode);
                                    break;
                                case "eval":
                                    PrimeFaces.ajax.ResponseProcessor.doEval(currentChangeNode);
                                    break;
                                case "extension":
                                    PrimeFaces.ajax.ResponseProcessor.doExtension(currentChangeNode, xhr);
                                    break;
                            }
                        }

                        PrimeFaces.ajax.Response.handleReFocus();
                        PrimeFaces.ajax.Response.destroyDetachedWidgets();
                        break;

                    case "eval":
                        PrimeFaces.ajax.ResponseProcessor.doEval(currentNode);
                        break;

                    case "extension":
                        PrimeFaces.ajax.ResponseProcessor.doExtension(currentNode, xhr);
                        break;
                        
                    case "error":
                        PrimeFaces.ajax.ResponseProcessor.doError(currentNode, xhr);
                        break;
                }
            }
        },

        handleReFocus : function() {
            var activeElementId = $(document.activeElement).attr('id');

            // re-focus element
            if (PrimeFaces.customFocus === false
                    && activeElementId
                    // do we really need to refocus? we just check the current activeElement here
                    && activeElementId !== $(document.activeElement).attr('id')) {

                var elementToFocus = $(PrimeFaces.escapeClientId(activeElementId));
                elementToFocus.focus();

                // double check it - required for IE
                setTimeout(function() {
                    if (!elementToFocus.is(":focus")) {
                        elementToFocus.focus();
                    }
                }, 150);
            }

            PrimeFaces.customFocus = false;
        },

        destroyDetachedWidgets : function() {
            // destroy detached widgets
            for (var i = 0; i < PrimeFaces.detachedWidgets.length; i++) {
                var widgetVar = PrimeFaces.detachedWidgets[i];

                var widget = PF(widgetVar);
                if (widget) {
                    if (widget.isDetached()) {
                        PrimeFaces.widgets[widgetVar] = null;
                        widget.destroy();

                        try {
                            delete widget;
                        } catch (e) {}
                    }
                }
            }

            PrimeFaces.detachedWidgets = [];
        }
    },
    
    ResponseProcessor: {
        
        doRedirect : function(node) {
            window.location = node.getAttribute('url');
        },

        doUpdate : function(node, xhr, updateHandler) {
            var id = node.getAttribute('id'),
            content = PrimeFaces.ajax.Utils.getContent(node);

            if (updateHandler && updateHandler.widget.id === id) {
                updateHandler.handle.call(updateHandler.widget, content);
            } else {
                PrimeFaces.ajax.Utils.updateElement(id, content, xhr);
            }
        },

        doEval : function(node) {
            var textContent = node.textContent || node.innerText || node.text;
            $.globalEval(textContent);
        },

        doExtension : function(node, xhr) {
            if (xhr) {
                if (node.getAttribute("ln") === "primefaces" && node.getAttribute("type") === "args") {
                    var textContent = node.textContent || node.innerText || node.text;
                    xhr.pfArgs = $.parseJSON(textContent);
                }
            }
        },

        doError : function(node, xhr) {
            // currently nothing...
        },

        doDelete : function(node) {
            var id = node.getAttribute('id');
            $(PrimeFaces.escapeClientId(id)).remove();
        },

        doInsert : function(node) {
            if (!node.childNodes) {
                return false;
            }

            for (var i = 0; i < node.childNodes.length; i++) {
                var childNode = node.childNodes[i];
                var id = childNode.getAttribute('id');
                var jq = $(PrimeFaces.escapeClientId(id));
                var content = PrimeFaces.ajax.Utils.getContent(childNode);

                if (childNode.nodeName === "after") {
                    $(content).insertAfter(jq);
                }
                else if (childNode.nodeName === "before") {
                    $(content).insertBefore(jq);
                }
            }
        },

        doAttributes : function(node) {
            if (!node.childNodes) {
                return false;
            }

            var id = node.getAttribute('id');
            var jq = $(PrimeFaces.escapeClientId(id));

            for (var i = 0; i < node.childNodes.length; i++) {
                var attrNode = node.childNodes[i];
                var attrName = attrNode.getAttribute("name");
                var attrValue = attrNode.getAttribute("value");

                if (!attrName) {
                    return;
                }

                if (!attrValue || attrValue === null) {
                    attrValue = "";
                }

                jq.attr(attrName, attrValue);
            }
        }
    },
    
    //Backward compatibility
    AjaxRequest: function(cfg, ext) {
        return PrimeFaces.ajax.Request.handle(cfg, ext);
    },
    
    //Backward compatibility
    AjaxUtils: {
        
        getContent : function(update) {
            return PrimeFaces.ajax.Utils.getContent(update.get(0));
        },

        updateElement : function(id, data, xhr) {
            PrimeFaces.ajax.Utils.updateElement(id, data, xhr);
        },

        handleResponse: function(xml) {
            //just for backward compatibility
            //we just always return true, so that no update will be processed
            //it will actually be done in the widgets itself
            PrimeFaces.ajax.Response.handle(xml, null, null, function(id, content) {
                return true;
            });
        }
    } 
};
PrimeFaces.expressions = {};

PrimeFaces.expressions.SearchExpressionFacade = {

	resolveComponentsAsSelector: function(expressions) {

		var splittedExpressions = PrimeFaces.expressions.SearchExpressionFacade.splitExpressions(expressions);
		var elements = $();

		if (splittedExpressions) {
			for (var i = 0; i < splittedExpressions.length; ++i) {
				var expression =  $.trim(splittedExpressions[i]);
				if (expression.length > 0) {

					// skip unresolvable keywords
					if (expression == '@none' || expression == '@all') {
						continue;
					}

					// just a id
					if (expression.indexOf("@") == -1) {
						elements = elements.add(
								$(document.getElementById(expression)));
					}
					// @widget
					else if (expression.indexOf("@widgetVar(") == 0) {
						var widgetVar = expression.substring(11, expression.length - 1);
						var widget = PrimeFaces.widgets[widgetVar];

						if (widget) {
							elements = elements.add(
									$(document.getElementById(widget.id)));
						} else {
							PrimeFaces.error("Widget for widgetVar \"" + widgetVar + "\" not avaiable");
						}
					}
					// PFS
					else if (expression.indexOf("@(") == 0) {
						//converts pfs to jq selector e.g. @(div.mystyle :input) to div.mystyle :input
						elements = elements.add(
								$(expression.substring(2, expression.length - 1)));
					}
				}
			}
		}

		return elements;
	},

	resolveComponents: function(expressions) {
		var splittedExpressions = PrimeFaces.expressions.SearchExpressionFacade.splitExpressions(expressions);
		var ids = [];

		if (splittedExpressions) {
			for (var i = 0; i < splittedExpressions.length; ++i) {
				var expression =  $.trim(splittedExpressions[i]);
				if (expression.length > 0) {

					// just a id or passtrough keywords
					if (expression.indexOf("@") == -1 || expression == '@none' || expression == '@all') {
						if (!PrimeFaces.inArray(ids, expression)) {
							ids.push(expression);
						}
					}
					// @widget
					else if (expression.indexOf("@widgetVar(") == 0) {
						var widgetVar = expression.substring(11, expression.length - 1);
						var widget = PrimeFaces.widgets[widgetVar];

						if (widget) {
							if (!PrimeFaces.inArray(ids, widget.id)) {
								ids.push(widget.id);
							}
						} else {
							PrimeFaces.error("Widget for widgetVar \"" + widgetVar + "\" not avaiable");
						}
					}
					// PFS
					else if (expression.indexOf("@(") == 0) {
						//converts pfs to jq selector e.g. @(div.mystyle :input) to div.mystyle :input
						var elements = $(expression.substring(2, expression.length - 1));

						for (var j = 0; j < elements.length; j++) {
							var element = $(elements[j]);
							var clientId = element.data(PrimeFaces.CLIENT_ID_DATA) || element.attr('id');

							if (!PrimeFaces.inArray(ids, clientId)) {
								ids.push(clientId);
							}
						}
					}
				}
			}
		}

		return ids;
	},

	splitExpressions: function(expression) {

		if (PrimeFaces.isIE(7)) {
			expression = expression.split('');
		}

		var expressions = [];
		var buffer = '';

		var parenthesesCounter = 0;

		for (var i = 0; i < expression.length; i++) {
			var c = expression[i];

			if (c === '(') {
				parenthesesCounter++;
			}

			if (c === ')') {
				parenthesesCounter--;
			}

			if ((c === ' ' || c === ',') && parenthesesCounter === 0) {
				// lets add token inside buffer to our tokens
				expressions.push(buffer);
				// now we need to clear buffer
				buffer = '';
			} else {
				buffer += c;
			}
		}

		// lets not forget about part after the separator
		expressions.push(buffer);

		return expressions;
	}	
};

/* Simple JavaScript Inheritance
 * By John Resig http://ejohn.org/
 * MIT Licensed.
 */
// Inspired by base2 and Prototype
(function(){
  var initializing = false, fnTest = /xyz/.test(function(){xyz;}) ? /\b_super\b/ : /.*/;
  // The base Class implementation (does nothing)
  this.Class = function(){};

  // Create a new Class that inherits from this class
  Class.extend = function(prop) {
    var _super = this.prototype;

    // Instantiate a base class (but only create the instance,
    // don't run the init constructor)
    initializing = true;
    var prototype = new this();
    initializing = false;

    // Copy the properties over onto the new prototype
    for (var name in prop) {
      // Check if we're overwriting an existing function
      prototype[name] = typeof prop[name] == "function" && 
        typeof _super[name] == "function" && fnTest.test(prop[name]) ?
        (function(name, fn){
          return function() {
            var tmp = this._super;

            // Add a new ._super() method that is the same method
            // but on the super-class
            this._super = _super[name];

            // The method only need to be bound temporarily, so we
            // remove it when we're done executing
            var ret = fn.apply(this, arguments);        
            this._super = tmp;

            return ret;
          };
        })(name, prop[name]) :
        prop[name];
    }

    // The dummy class constructor
    function Class() {
      // All construction is actually done in the init method
      if ( !initializing && this.init )
        this.init.apply(this, arguments);
    }

    // Populate our constructed prototype object
    Class.prototype = prototype;

    // Enforce the constructor to be what we expect
    Class.prototype.constructor = Class;

    // And make this class extendable
    Class.extend = arguments.callee;

    return Class;
  };
})();

PrimeFaces.widget = {};

/**
 * BaseWidget for PrimeFaces Widgets
 */
PrimeFaces.widget.BaseWidget = Class.extend({

    init: function(cfg) {
        this.cfg = cfg;
        this.id = cfg.id;
        this.jqId = PrimeFaces.escapeClientId(this.id);
        this.jq = $(this.jqId);
        this.widgetVar = cfg.widgetVar;
        
        //remove script tag
        $(this.jqId + '_s').remove();
        
        if (this.widgetVar) {
            var $this = this;
            this.jq.on("remove", function() {
            	PrimeFaces.detachedWidgets.push($this.widgetVar);
            });
        }
    },

    //used in ajax updates, reloads the widget configuration
    refresh: function(cfg) {
        return this.init(cfg);
    },
    
    //will be called when the widget after a ajax request if the widget is detached
    destroy: function() {
    	PrimeFaces.debug("Destroyed detached widget: " + this.widgetVar);
    },

    //checks if the given widget is detached
    isDetached: function() {
    	return document.getElementById(this.id) === null;
    },

    //returns jquery object representing the main dom element related to the widget
    getJQ: function(){
        return this.jq;
    },

	/**
	 * Removes the widget's script block from the DOM.
	 *
	 * @param {string} clientId The id of the widget.
	 */
    removeScriptElement: function(clientId) {
    	$(PrimeFaces.escapeClientId(clientId) + '_s').remove();
    }
});
    
/**
 * Widgets that require to be visible to initialize properly for hidden container support
 */
PrimeFaces.widget.DeferredWidget = PrimeFaces.widget.BaseWidget.extend({

    renderDeferred: function() {     
        if(this.jq.is(':visible')) {
            this._render();
        }
        else {
            var hiddenParent = this.jq.closest('.ui-hidden-container'),
            hiddenParentWidgetVar = hiddenParent.data('widget'),
            $this = this;

            if(hiddenParentWidgetVar) {
                var hiddenParentWidget = PF(hiddenParentWidgetVar);
                
                if(hiddenParentWidget) {
                    hiddenParentWidget.addOnshowHandler(this.id, function() {
                        return $this.render();
                    });
                }
            }
        }
    },
    
    render: function() {
        if(this.jq.is(':visible')) {
            this._render();
            return true;
        }
        else {
            return false;
        }
    },
    
    /**
     * Must be overriden
     */
    _render: function() {
        throw 'Unsupported Operation';
    }
});
$(document).on('pfAjaxStart', function() {
    $.mobile.loading('show');
});

$(document).on('pfAjaxComplete', function() {
    $.mobile.loading('hide');
});

PrimeFaces.Mobile = {
    
    navigate: function(to, cfg) {
        cfg.changeHash = cfg.changeHash||false;
        
        var targetPage = $(to);
        if(targetPage.hasClass('ui-lazypage')) {
            var pageId = to.substring(1),
            options = {
                source: pageId,
                process: pageId,
                update: pageId,
                params: [
                    {name: pageId + '_lazyload', value: true}
                ],
                oncomplete: function() {
                    $(to).page();
                    $('body').pagecontainer('change', to, cfg);
                }
            };

            PrimeFaces.ajax.Request.handle(options);
        }
        else {
            $('body').pagecontainer('change', to, cfg);
        }
    }
    
};
/**
 * PrimeFaces Mobile AccordionPanel Widget
 */
PrimeFaces.widget.AccordionPanel = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.tabs = this.jq.children('.ui-collapsible');
        this.headers = this.tabs.children('.ui-collapsible-heading');
        this.contents = this.tabs.children('.ui-collapsible-content');
        this.stateHolder = $(this.jqId + '_active');
        
        this.initActive();
        this.bindEvents();
        
        if(this.cfg.dynamic && this.cfg.cache) {
            this.markLoadedPanels();
        }
    },
    
    initActive: function() {
        if(this.cfg.multiple) {
            var indexes = this.stateHolder.val().split(',');
            for(var i = 0; i < indexes.length; i++) {
                indexes[i] = parseInt(indexes[i]);
            }
            
            this.cfg.active = indexes;
        }
        else {
            this.cfg.active = parseInt(this.stateHolder.val());
        }
    },
    
    bindEvents: function() {
        var $this = this;
    
        this.headers.on('click.accordionPanel', function(e) {            
            var element = $(this);
            if(!element.hasClass('ui-state-disabled')) {
                var tabIndex = element.parent().index();

                if(element.hasClass('ui-collapsible-heading-collapsed'))
                    $this.select(tabIndex);
                else
                    $this.unselect(tabIndex);
            }

            e.preventDefault();
        });
    },
    
    markLoadedPanels: function() {
        if(this.cfg.multiple) {
            for(var i = 0; i < this.cfg.active.length; i++) {
                if(this.cfg.active[i] >= 0)
                    this.markAsLoaded(this.tabs.eq(this.cfg.active[i]));
            }
        } else {
            if(this.cfg.active >= 0)
                this.markAsLoaded(this.tabs.eq(this.cfg.active));
        }
    },
    
    select: function(index) {
        var tab = this.tabs.eq(index);

        if(this.cfg.onTabChange) {
            var result = this.cfg.onTabChange.call(this, tab);
            if(result === false)
                return false;
        }

        var shouldLoad = this.cfg.dynamic && !this.isLoaded(tab);

        if(this.cfg.multiple)
            this.addToSelection(index);
        else
            this.cfg.active = index;

        this.saveState();

        if(shouldLoad) {
            this.loadDynamicTab(tab);
        }
        else {
            this.show(tab);
            this.fireTabChangeEvent(tab);
        }

        return true;
    },
    
    show: function(tab) {
        var header = tab.children('.ui-collapsible-heading'),
        content = tab.children('.ui-collapsible-content');

        //deactivate current
        if(!this.cfg.multiple) {
            this.close(this.tabs.filter(':not(.ui-collapsible-collapsed)'));
        }

        tab.removeClass('ui-collapsible-collapsed').attr('aria-expanded', true);
        header.removeClass('ui-collapsible-heading-collapsed')
                .children('.ui-collapsible-heading-toggle').removeClass('ui-icon-plus').addClass('ui-icon-minus');
        content.removeClass('ui-collapsible-content-collapsed').attr('aria-hidden', false).show();
    },
    
    close: function(tab) {
        tab.addClass('ui-collapsible-collapsed').attr('aria-expanded', false);
        tab.children('.ui-collapsible-heading').addClass('ui-collapsible-heading-collapsed')
                .children('.ui-collapsible-heading-toggle').addClass('ui-collapsible-heading-collapsed').removeClass('ui-icon-minus').addClass('ui-icon-plus');
        tab.children('.ui-collapsible-content').attr('aria-hidden', true)
                .addClass('ui-collapsible-content-collapsed').attr('aria-hidden', true).hide();
    },

    unselect: function(index) {
        this.close(this.tabs.eq(index))

        this.removeFromSelection(index);
        this.saveState();
        
        if(this.hasBehavior('tabClose')) {
            this.fireTabCloseEvent(tab);
        }
    },
    
    addToSelection: function(nodeId) {
        this.cfg.active.push(nodeId);
    },

    removeFromSelection: function(index) {
        this.cfg.active = $.grep(this.cfg.active, function(r) {
            return (r !== index);
        });
    },
    
    saveState: function() {
        if(this.cfg.multiple)
            this.stateHolder.val(this.cfg.active.join(','));
        else
            this.stateHolder.val(this.cfg.active);
    },
    
    loadDynamicTab: function(tab) {
        var $this = this,
        options = {
            source: this.id,
            process: this.id,
            update: this.id,
            params: [
                {name: this.id + '_contentLoad', value: true},
                {name: this.id + '_newTab', value: tab.attr('id')},
                {name: this.id + '_tabindex', value: tab.index()}
            ],
            onsuccess: function(responseXML, status, xhr) {
                PrimeFaces.ajax.Response.handle(responseXML, status, xhr, {
                        widget: $this,
                        handle: function(content) {
                            tab.find('> .ui-collapsible-content > p').html(content);

                            if(this.cfg.cache) {
                                this.markAsLoaded(tab);
                            }   
                        }
                    });

                return true;
            },
            oncomplete: function() {
                $this.show(tab);
            }
        };

        if(this.hasBehavior('tabChange')) {
            this.cfg.behaviors['tabChange'].call(this, options);
        }
        else {
            PrimeFaces.ajax.AjaxRequest(options);
        }
    },
    
    fireTabChangeEvent : function(tab) {
        if(this.hasBehavior('tabChange')) {
            var tabChangeBehavior = this.cfg.behaviors['tabChange'],
            ext = {
                params: [
                    {name: this.id + '_newTab', value: tab.attr('id')},
                    {name: this.id + '_tabindex', value: parseInt(tab.index())}
                ]
            };

            tabChangeBehavior.call(this, ext);
        }        
    },

    fireTabCloseEvent : function(tab) {
        var tabCloseBehavior = this.cfg.behaviors['tabClose'],
        ext = {
            params: [
                {name: this.id + '_tabId', value: tab.attr('id')},
                {name: this.id + '_tabindex', value: parseInt(tab.index())}
            ]
        };
        
        tabCloseBehavior.call(this, ext);
    },
    
    markAsLoaded: function(tab) {
        tab.data('loaded', true);
    },

    isLoaded: function(tab) {
        return tab.data('loaded') === true;
    },
    
    hasBehavior: function(event) {
        if(this.cfg.behaviors) {
            return this.cfg.behaviors[event] != undefined;
        }

        return false;
    }
    
});
/**
 * PrimeFaces Mobile AutoComplete Widget
 */
PrimeFaces.widget.AutoComplete = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.cfg.minLength = (this.cfg.minLength !== undefined) ? this.cfg.minLength : 1;
        this.cfg.delay = (this.cfg.delay !== undefined) ? this.cfg.delay : 300;
        this.inputContainer = this.jq.children('.ui-input-search');
        this.input = $(this.jqId + '_input');
        this.hinput = $(this.jqId + '_hinput');
        this.clearIcon = this.inputContainer.children('.ui-input-clear');
        this.cfg.pojo = (this.hinput.length === 1);
        this.panel = this.jq.children('.ui-controlgroup');
        this.itemContainer = this.panel.children('.ui-controlgroup-controls');
        
        this.bindEvents();
        
        //pfs metadata
        this.input.data(PrimeFaces.CLIENT_ID_DATA, this.id);
        this.hinput.data(PrimeFaces.CLIENT_ID_DATA, this.id);
    },
    
    bindEvents: function() {
        var $this = this;

        this.input.on('keyup.autoComplete', function(e) {
            var value = $this.input.val();

            if(value.length === 0) {
                $this.hide();
            }
            else {
                $this.showClearIcon();
            }

            if(value.length >= $this.cfg.minLength) {
                //Cancel the search request if user types within the timeout
                if($this.timeout) {
                    clearTimeout($this.timeout);
                }

                $this.timeout = setTimeout(function() {
                    $this.search(value);
                }, $this.cfg.delay);
            }
        });
        
        this.clearIcon.on('click.autoComplete', function(e) {
            $this.input.val('');
            $this.hinput.val('');
            $this.hide();
        });
    },
    
    bindDynamicEvents: function() {
        var $this = this;

        //visuals and click handler for items
        this.items.on('click.autoComplete', function(event) {
            var item = $(this),
            itemValue = item.attr('data-item-value');

            $this.input.val(item.attr('data-item-label')).focus();

            if($this.cfg.pojo) {
                $this.hinput.val(itemValue); 
            }

            $this.fireItemSelectEvent(event, itemValue);
            $this.hide();
        });
    },
    
    search: function(query) {
        //allow empty string but not undefined or null
        if(query === undefined || query === null) {
            return;
        }

        var $this = this,
        options = {
            source: this.id,
            process: this.id,
            update: this.id,
            formId: this.cfg.formId,
            onsuccess: function(responseXML, status, xhr) {
                PrimeFaces.ajax.Response.handle(responseXML, status, xhr, {
                    widget: $this,
                    handle: function(content) {
                        this.itemContainer.html(content);

                        this.showSuggestions();
                    }
                });
                
                return true;
            }
        };

        options.params = [
            {name: this.id + '_query', value: query}  
        ];
        
        if(this.hasBehavior('query')) {
            var queryBehavior = this.cfg.behaviors['query'];
            queryBehavior.call(this, options);
        } 
        else {
            PrimeFaces.ajax.Request.handle(options); 
        }
    },
    
    show: function() {
        this.panel.removeClass('ui-screen-hidden');
    },
    
    hide: function() {        
        this.panel.addClass('ui-screen-hidden');
        this.hideClearIcon();
    },
    
    showSuggestions: function() {
        this.items = this.itemContainer.children('.ui-autocomplete-item');                   
        this.bindDynamicEvents();
                
        if(this.items.length) {
            this.items.first().addClass('ui-first-child');
            this.items.last().addClass('ui-last-child');
            
            if(this.panel.is(':hidden')) {
                this.show();
            }
        }
        else {
            if(this.cfg.emptyMessage) { 
                var emptyText = '<div class="ui-autocomplete-emptyMessage ui-widget">'+this.cfg.emptyMessage+'</div>';
                this.itemContainer.html(emptyText);
            }
            else {
                this.hide();
            }
        }
    },
    
    fireItemSelectEvent: function(event, itemValue) {
        if(this.hasBehavior('itemSelect')) {
            var ext = {
                params : [
                    {name: this.id + '_itemSelect', value: itemValue}
                ]
            };

            this.cfg.behaviors['itemSelect'].call(this, ext);
        }
    },
    
    hasBehavior: function(event) {
        if(this.cfg.behaviors) {
            return this.cfg.behaviors[event] !== undefined;
        }
    
        return false;
    },
    
    showClearIcon: function() {
        this.clearIcon.removeClass('ui-input-clear-hidden');
    },
    
    hideClearIcon: function() {
        this.clearIcon.addClass('ui-input-clear-hidden');
    }
    
});
/**
 * PrimeFaces Calendar Widget
 */
PrimeFaces.widget.Calendar = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.cfg.inline = !this.cfg.popup;
        this.input = $(this.jqId + '_input');
        var $this = this;

        this.configureLocale();

        //disabled dates
        this.cfg.beforeShowDay = function(date) { 
            if($this.cfg.preShowDay)
                return $this.cfg.preShowDay(date);
            else if($this.cfg.disabledWeekends)
                return $.datepicker.noWeekends(date);
            else
                return [true,''];
        }
        
        this.bindEvents();

        if(!this.cfg.disabled) {
            this.input.date(this.cfg);
        }
                        
        //pfs metadata
        this.input.data(PrimeFaces.CLIENT_ID_DATA, this.id);
    },
        
    refresh: function(cfg) {
        this.init(cfg);
    },
    
    configureLocale: function() {
        var localeSettings = PrimeFaces.locales[this.cfg.locale];

        if(localeSettings) {
            for(var setting in localeSettings) {
                if(localeSettings.hasOwnProperty(setting)) {
                    this.cfg[setting] = localeSettings[setting];
                }
            }
        }
    },
    
    bindEvents: function() {
        var $this = this;

        this.cfg.onSelect = function() {
            $this.fireDateSelectEvent();
            
            setTimeout( function(){
                $this.input.date( "addMobileStyle" );
            },0);
        };
    },
    
    fireDateSelectEvent: function() {
        if(this.cfg.behaviors) {
            var dateSelectBehavior = this.cfg.behaviors['dateSelect'];

            if(dateSelectBehavior) {
                dateSelectBehavior.call(this);
            }
        }
    },
    
    setDate: function(date) {
        this.input.date('setDate', date);
    },
    
    getDate: function() {
        return this.input.date('getDate');
    },
    
    enable: function() {
        this.input.date('enable');
    },
    
    disable: function() {
        this.input.date('disable');
    }
    
});
/**
 * PrimeFaces Mobile DataList Widget
 */
PrimeFaces.widget.DataList = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.jq.listview();
        this.items = this.jq.children('li');
        
        this.bindEvents();
    },
    
    bindEvents: function() {
        if(this.cfg.behaviors) {
            var $this = this;
            
            $.each(this.cfg.behaviors, function(eventName, fn) {
                $this.items.on(eventName, function() {
                    var ext = {
                        params: [{name: $this.id + '_item', value: $(this).index()}]
                    };
                            
                    fn.call($this, ext);
                });
            });
        }
    }
});
/**
 * PrimeFaces Mobile Dialog Widget
 */
PrimeFaces.widget.Dialog = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.content = this.jq.children('.ui-content');
        this.titlebar = this.jq.children('.ui-header');
        this.closeIcon = this.titlebar.children('.ui-icon-delete');
        
        this.jq.popup({
            positionTo: 'window',
            dismissible: false,
            overlayTheme: 'b'
        });
    
        this.bindEvents();
    },
        
    bindEvents: function() {
        var $this = this;
        
        this.closeIcon.on('click', function(e) {
            $this.hide();
            e.preventDefault();
        });
    },
    
    show: function() {
        this.jq.removeClass('ui-dialog-container').popup('open', {transition:this.cfg.showEffect});
    },
    
    hide: function() {
        this.jq.popup('close');
    }
});
/**
 * PrimeFaces Mobile InputText Widget
 */
PrimeFaces.widget.InputText = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.input = this.jq.children('input');
        this.cfg.enhanced = true;
        this.cfg.clearBtn = true;
        
        this.input.textinput(this.cfg);
    }
    
});

/**
 * PrimeFaces Mobile InputTextarea Widget
 */
PrimeFaces.widget.InputTextarea = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.cfg.enhanced = true;
        this.cfg.autogrow = false;
        
        this.jq.textinput(this.cfg);
    }
    
});

/**
 * PrimeFaces SelectOneButton Widget
 */
PrimeFaces.widget.SelectOneButton = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.controlGroup = this.jq.children('.ui-controlgroup-controls');
        this.buttons = this.controlGroup.find('> .ui-radio > label.ui-btn');
        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
                
        this.buttons.on('click.selectOneButton', function(e) {
            var button = $(this);

            if(!button.hasClass('ui-btn-active')) {
                $this.select(button);
            }
        });
    },
    
    select: function(button) {
        this.buttons.filter('.ui-btn-active').removeClass('ui-btn-active').next().prop('checked', false);

        button.addClass('ui-btn-active').next().prop('checked', true).change();
    }
    
});

/**
 * PrimeFaces SelecyManyButton Widget
 */
PrimeFaces.widget.SelectManyButton = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.controlGroup = this.jq.children('.ui-controlgroup-controls ');
        this.buttons = this.controlGroup.find('> .ui-checkbox > label.ui-btn');
        
        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
        this.buttons.on('click.selectManyButton', function() {
            var button = $(this);

            if(button.hasClass('ui-btn-active'))
                $this.unselect(button);
            else
                $this.select(button);
        });
    },
    
    select: function(button) {
        button.addClass('ui-btn-active').next().prop('checked', true).change();

    },
    
    unselect: function(button) {
        button.removeClass('ui-btn-active').next().prop('checked', false).change();
    }
    
});

/**
 * PrimeFaces Mobile InputSlider Widget
 */
PrimeFaces.widget.InputSlider = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.jq.slider();
    }
    
});

/**
 * PrimeFaces Mobile RangeSlider Widget
 */
PrimeFaces.widget.RangeSlider = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.jq.attr('data-role', 'rangeslider');
        this.jq.rangeslider();
    }
    
});

/**
 * PrimeFaces Mobile UISwitch Widget
 */
PrimeFaces.widget.UISwitch = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.input = this.jq.children('input');
        this.cfg.enhanced = true;
        
        this.input.flipswitch(this.cfg);
    }
    
});

/**
 * PrimeFaces Mobile SelectOneMenu Widget
 */
PrimeFaces.widget.SelectOneMenu = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.jq.selectmenu(this.cfg).removeAttr('id');
        this.jq.closest('.ui-select').attr('id', this.id);
    }
    
});

/**
 * PrimeFaces Mobile SelectOneRadio Widget
 */
PrimeFaces.widget.SelectOneRadio = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.jq.controlgroup();
    }
    
});

/**
 * PrimeFaces Mobile SelectManyCheckbox Widget
 */
PrimeFaces.widget.SelectManyCheckbox = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.jq.controlgroup();
    }
    
});

/**
 * PrimeFaces Mobile SelectBooleanCheckbox Widget
 */
PrimeFaces.widget.SelectBooleanCheckbox = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.label = this.jq.children('label');
        this.input = this.jq.children(':checkbox');
        
        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
        
        this.label.on('click.selectBooleanCheckbox', function() {
            $this.toggle();
        });
    },
    
    toggle: function() {
        if(this.input.prop('checked'))
            this.uncheck();
        else
            this.check();
        
        this.input.trigger('change');
    },
    
    check: function() {
        this.label.removeClass('ui-checkbox-off').addClass('ui-checkbox-on');
    },
    
    uncheck: function() {
        this.label.removeClass('ui-checkbox-on').addClass('ui-checkbox-off');
    }
});

/**
 * PrimeFaces Mobile SelectCheckboxMenu Widget
 */
PrimeFaces.widget.SelectCheckboxMenu = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.cfg.nativeMenu = false;
        
        this.jq.selectmenu(this.cfg).removeAttr('id');
        this.jq.closest('.ui-select').attr('id', this.id);
    }
    
});


/**
 * PrimeFaces Mobile Growl Widget
 */
PrimeFaces.widget.Growl = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.initOptions(cfg);
        
        this.jq.popup({
            positionTo: 'window',
            theme: 'b'
        });
        
        this.container = $(this.jqId + '-popup');
        this.popupContainer = this.container.find('> div.ui-popup');
        this.popupContainer.append('<p></p>');
        this.messageContainer = this.popupContainer.children('p');
        this.placeholder = $(this.jqId + '-placeholder');
        
        this.popupContainer.removeAttr('id');
        this.placeholder.attr('id', this.id);
        
        this.show(this.cfg.msgs);
    },
    
    initOptions: function(cfg) {
        this.cfg = cfg;
        this.cfg.sticky = this.cfg.sticky||false;
        this.cfg.life = this.cfg.life||6000;
        this.cfg.escape = (this.cfg.escape === false) ? false : true;
    },
    
    refresh: function(cfg) {
    	this.initOptions(cfg);
        this.show(cfg.msgs);
    },
    
    show: function(msgs) {
        var $this = this;

        this.removeAll();

        if(msgs.length) {
            $.each(msgs, function(index, msg) {
                $this.renderMessage(msg);
            });

            this.jq.popup('open', {transition:'pop'});
            
            if(!this.cfg.sticky) {
                this.setRemovalTimeout();
            }
        }
    },
    
    removeAll: function() {
        this.messageContainer.children().remove();
    },
    
    renderMessage: function(msg) {
        var markup = '<div class="ui-growl-item ui-grid-a">';
        markup += '<div class="ui-growl-severity ui-block-a"><a class="ui-btn ui-shadow ui-corner-all ui-btn-icon-notext ui-btn-b ui-btn-inline" href="#"></a></div>';
        markup += '<div class="ui-growl-message ui-block-b">';
        markup += '<div class="ui-growl-summary"></div>';
        markup += '<div class="ui-growl-detail"></div>';
        markup += '</div></div>';
        
        var item = $(markup),
        severityEL = item.children('.ui-growl-severity'),
        summaryEL = item.find('> .ui-growl-message > .ui-growl-summary'),
        detailEL = item.find('> .ui-growl-message > .ui-growl-detail');

        severityEL.children('a').addClass(this.getSeverityIcon(msg.severity));
        
        if(this.cfg.escape) {
            summaryEL.text(msg.summary);
            detailEL.text(msg.detail);
        }
        else {
            summaryEL.html(msg.summary);
            detailEL.html(msg.detail);
        }
                
        this.messageContainer.append(item);
    },
    
    getSeverityIcon: function(severity) {
        var icon;
        
        switch(severity) {
            case 'info':
                icon = 'ui-icon-info';
                break;
            break;
    
            case 'warn':
                icon = 'ui-icon-alert';
                break;
            break;
    
            case 'error':
                icon = 'ui-icon-delete';
                break;
            break;
    
            case 'fatal':
                icon = 'ui-icon-delete';
                break;
            break;
        }
        
        return icon;
    },
        
    setRemovalTimeout: function() {
        var $this = this;
        
        if(this.timeout) {
            clearTimeout(this.timeout);
        }
        
        this.timeout = setTimeout(function() {
            $this.jq.popup('close');
        }, this.cfg.life);
    }
});

/**
 * PrimeFaces Mobile Menu Widget
 */
PrimeFaces.widget.PlainMenu = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.items = this.jq.children('li');
        this.items.filter(':first-child').addClass('ui-first-child');
        this.items.filter(':last-child').addClass('ui-last-child');
    }
});

/**
 * PrimeFaces Mobile TabMenu Widget
 */
PrimeFaces.widget.TabMenu = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.links = this.jq.find('a.ui-link');
        this.links.eq(this.cfg.activeIndex).addClass('ui-btn-active');
        
        this.jq.navbar();
    }
});
/**
 * PrimeFaces Mobile OverlayPanel Widget
 */
PrimeFaces.widget.OverlayPanel = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.cfg.visible = false;
        this.cfg.showEvent = this.cfg.showEvent||'click.overlaypanel';
        this.cfg.hideEvent = this.cfg.hideEvent||'click.overlaypanel';
        this.cfg.target = this.cfg.targetId ? $(PrimeFaces.escapeClientId(this.cfg.targetId)): null;
        
        this.jq.panel({
            position: this.cfg.at,
            display: this.cfg.showEffect,
            dismissable: this.cfg.dismissable
        });
        
        if(this.cfg.dynamic) {
            this.jq.append('<div class="ui-panel-inner"></div>');
            this.content = this.jq.children('div.ui-panel-inner');
        }

        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
        
        if(this.cfg.target) {
            if(this.cfg.showEvent === this.cfg.hideEvent) {
                this.cfg.target.on(this.cfg.showEvent, function(e) {
                    $this.toggle();
                });
            }
            else {
                this.cfg.target.on(this.cfg.showEvent, function(e) {
                    $this.show();
                })
                .on(this.cfg.hideEffect, function(e) {
                    $this.hide();
                })
            }
        }
    },
    
    show: function() {
        if(!this.loaded && this.cfg.dynamic)
            this.loadContents();
        else
            this._show();
    },
    
    _show: function() {
        this.jq.panel('open');
        this.cfg.visible = true;
        
        if(this.cfg.onShow) {
            this.cfg.onShow.call(this);
        }
    },
    
    hide: function() {
        this.jq.panel('close');
        this.cfg.visible = false;
        
        if(this.cfg.onHide) {
            this.cfg.onHide.call(this);
        }
    },
    
    toggle: function() {
        if(this.cfg.visible)
            this.hide();
        else
            this.show();
    },
    
    loadContents: function() {
        var $this = this,
        options = {
            source: this.id,
            process: this.id,
            update: this.id,
            params: [
                {name: this.id + '_contentLoad', value: true}
            ],
            onsuccess: function(responseXML, status, xhr) {
                PrimeFaces.ajax.Response.handle(responseXML, status, xhr, {
                        widget: $this,
                        handle: function(content) {
                            this.content.html(content);
                            this.loaded = true;
                        }
                    });

                return true;
            },
            oncomplete: function() {
                $this._show();
            }
        };

        PrimeFaces.ajax.Request.handle(options);
    }
});

/**
 * PrimeFaces Mobile Panel Widget
 */
PrimeFaces.widget.Panel = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.header = this.jq.children('.ui-panel-m-titlebar');
        this.content = this.jq.children('.ui-panel-m-content');
        this.onshowHandlers = this.onshowHandlers||{};
        
        this.bindEvents();
    },
    
    bindEvents: function() {
        var $this = this;
        
        if(this.cfg.toggleable) {
            this.toggler = this.header.children('.ui-panel-m-titlebar-icon');
            this.toggleStateHolder = $(this.jqId + '_collapsed');
            
            this.toggler.on('click', function(e) {
                $this.toggle();
                
                e.preventDefault();
            });
        }
    },
    
    toggle: function() {
        if(this.content.is(':visible'))
            this.collapse();
        else
            this.expand();
    },
    
    collapse: function() {
        this.toggleState(true, 'ui-icon-minus', 'ui-icon-plus');
        this.content.hide();
    },
    
    expand: function() {
        this.toggleState(false, 'ui-icon-plus', 'ui-icon-minus');
        this.content.show();
        this.invokeOnshowHandlers();
    },
    
    toggleState: function(collapsed, removeIcon, addIcon) {
        this.toggler.removeClass(removeIcon).addClass(addIcon);
        this.cfg.collapsed = collapsed;
        this.toggleStateHolder.val(collapsed);
        this.fireToggleEvent();
    },
    
    fireToggleEvent: function() {
        if(this.cfg.behaviors) {
            var toggleBehavior = this.cfg.behaviors['toggle'];
            
            if(toggleBehavior) {
                toggleBehavior.call(this);
            }
        }
    },
    
    addOnshowHandler: function(id, fn) {
        this.onshowHandlers[id] = fn;
    },
    
    invokeOnshowHandlers: function() {
        for(var id in this.onshowHandlers) {
            if(this.onshowHandlers.hasOwnProperty(id)) {
                var fn = this.onshowHandlers[id];
                
                if(fn.call()) {
                    delete this.onshowHandlers[id];
                }
            }
        }
    }
});
/**
 * PrimeFaces Mobile TabView Widget
 */
PrimeFaces.widget.TabView = PrimeFaces.widget.BaseWidget.extend({
    
    GRID_MAP: {
        '2': 'a',
        '3': 'b',
        '4': 'c',
        '5': 'd'
    },
    
    BLOCK_MAP: {
        '0': 'a',
        '1': 'b',
        '2': 'c',
        '3': 'd',
        '4': 'e'
    },
    
    init: function(cfg) {
        this._super(cfg);
        this.navbar = this.jq.children('.ui-navbar');
        this.navContainer = this.navbar.children('.ui-tabs-nav');
        this.headers = this.navContainer.children('.ui-tabs-header');
        this.panelContainer = this.jq.children('.ui-tabs-panels');
        this.stateHolder = $(this.jqId + '_activeIndex');
        this.cfg.selected = parseInt(this.stateHolder.val());
        this.onshowHandlers = this.onshowHandlers||{};
        this.initGrid();
        
        this.bindEvents();
        
        if(this.cfg.dynamic && this.cfg.cache) {
            this.markAsLoaded(this.panelContainer.children().eq(this.cfg.selected));
        }
        
    },
    
    initGrid: function() {
        var tabcount = this.headers.length;
        
        this.navContainer.addClass('ui-grid-' + this.GRID_MAP[tabcount.toString()]);
        
        for(var i = 0; i < tabcount; i++) {
            this.headers.eq(i).addClass('ui-block-' + this.BLOCK_MAP[(i % 5).toString()]);
        }
    },
    
    bindEvents: function() {
        var $this = this;

        //Tab header events
        this.headers.children('a')
                .on('click.tabView', function(e) {
                    var element = $(this),
                    index = element.parent().index();

                    if(!element.hasClass('ui-state-disabled') && (index !== $this.cfg.selected)) {
                        $this.select(index);
                    }

                    e.preventDefault();
                });

    },
    
    select: function(index, silent) {
        if(this.cfg.onTabChange && !silent) {
            var result = this.cfg.onTabChange.call(this, index);
            if(result === false)
                return false;
        }

        var newPanel = this.panelContainer.children().eq(index),
        shouldLoad = this.cfg.dynamic && !this.isLoaded(newPanel);

        this.stateHolder.val(index);
        this.cfg.selected = index;

        if(shouldLoad) {
            this.loadDynamicTab(newPanel);
        }
        else {
            this.show(newPanel);
            
            if(this.hasBehavior('tabChange') && !silent) {
                this.fireTabChangeEvent(newPanel);
            }
        }

        return true;
    },
    
    show: function(newPanel) {
        var oldHeader = this.headers.filter('.ui-tabs-active'),
        newHeader = this.headers.eq(newPanel.index()),
        oldPanel = this.panelContainer.children(':visible');

        oldPanel.attr('aria-hidden', true);
        oldHeader.attr('aria-expanded', false);
        newPanel.attr('aria-hidden', false);
        newHeader.attr('aria-expanded', true);

        oldHeader.removeClass('ui-tabs-active').children('a').removeClass('ui-btn-active');
        oldPanel.hide();

        newHeader.addClass('ui-tabs-active').children('a').addClass('ui-btn-active');
        newPanel.show();

        this.postTabShow(newPanel);
    },
    
    fireTabChangeEvent: function(panel) {
        var tabChangeBehavior = this.cfg.behaviors['tabChange'],
        ext = {
            params: [
                {name: this.id + '_newTab', value: panel.attr('id')},
                {name: this.id + '_tabindex', value: panel.index()}
            ]
        };
        
        tabChangeBehavior.call(this, ext);
    },
    
    loadDynamicTab: function(newPanel) {
        var $this = this,
        tabindex = newPanel.index(),
        options = {
            source: this.id,
            process: this.id,
            update: this.id,
            params: [
                {name: this.id + '_contentLoad', value: true},
                {name: this.id + '_newTab', value: newPanel.attr('id')},
                {name: this.id + '_tabindex', value: tabindex}
            ],
            onsuccess: function(responseXML, status, xhr) {
                PrimeFaces.ajax.Response.handle(responseXML, status, xhr, {
                        widget: $this,
                        handle: function(content) {
                            newPanel.children('p').html(content);

                            if(this.cfg.cache) {
                                this.markAsLoaded(newPanel);
                            }
                        }
                    });

                return true;
            },
            oncomplete: function() {
                $this.show(newPanel);
            }
        };

        if(this.hasBehavior('tabChange')) {
            this.cfg.behaviors['tabChange'].call(this, options);
        }
        else {
            PrimeFaces.ajax.Request.handle(options);
        }
    },
    
    postTabShow: function(newPanel) {    
        //execute user defined callback
        if(this.cfg.onTabShow) {
            this.cfg.onTabShow.call(this, newPanel.index());
        }

        //execute onshowHandlers and remove successful ones
        for(var id in this.onshowHandlers) {
            if(this.onshowHandlers.hasOwnProperty(id)) {
                var fn = this.onshowHandlers[id];
                
                if(fn.call()) {
                    delete this.onshowHandlers[id];
                }
            }
        }
    },
    
    hasBehavior: function(event) {
        if(this.cfg.behaviors) {
            return this.cfg.behaviors[event] !== undefined;
        }

        return false;
    },
    
    markAsLoaded: function(panel) {
        panel.data('loaded', true);
    },
    
    isLoaded: function(panel) {
        return panel.data('loaded') === true;
    }
    
});
