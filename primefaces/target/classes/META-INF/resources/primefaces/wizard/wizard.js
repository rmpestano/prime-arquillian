/**
 * PrimeFaces Wizard Component
 */
PrimeFaces.widget.Wizard = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        
        this.content = $(this.jqId + '_content');
        this.backNav = $(this.jqId + '_back');
        this.nextNav = $(this.jqId + '_next');
        this.cfg.formId = this.jq.parents('form:first').attr('id');
        this.currentStep = this.cfg.initialStep;
        
        var _self = this;
        
        //Step controls
        if(this.cfg.showStepStatus) {
            this.stepControls = $(this.jqId + ' .ui-wizard-step-titles li.ui-wizard-step-title');
        }

        //Navigation controls
        if(this.cfg.showNavBar) {
            var currentStepIndex = this.getStepIndex(this.currentStep);
            
            //visuals
            PrimeFaces.skinButton(this.backNav);
            PrimeFaces.skinButton(this.nextNav);

            //events
            this.backNav.click(function() {_self.back();});
            this.nextNav.click(function() {_self.next();});

            if(currentStepIndex == 0)
                this.backNav.hide();
            else if(currentStepIndex == this.cfg.steps.length - 1)
                this.nextNav.hide();
        }
    },
    
    back: function() {
        if(this.cfg.onback) {
            var value = this.cfg.onback.call(this);
            if(value == false) {
                return;
            }
        }

        var stepToGo = this.cfg.steps[this.getStepIndex(this.currentStep) - 1];

        this.loadStep(stepToGo, true);
    },
    
    next: function() {
        if(this.cfg.onnext) {
            var value = this.cfg.onnext.call(this);
            if(value == false) {
                return;
            }
        }

        var stepToGo = this.cfg.steps[this.getStepIndex(this.currentStep) + 1];

        this.loadStep(stepToGo, false);
    },
    
    loadStep: function(stepToGo, isBack) {
        var $this = this,
        options = {
            source: this.id,
            process: this.id,
            update: this.id,
            formId: this.cfg.formId,
            params: [
                {name: this.id + '_wizardRequest', value: true},
                {name: this.id + '_stepToGo', value: stepToGo}
            ],
            onsuccess: function(responseXML, status, xhr) {
                PrimeFaces.ajax.Response.handle(responseXML, status, xhr, {
                        widget: $this,
                        handle: function(content) {
                            this.content.html(content);
                        }
                    });

                return true;
            },
            oncomplete: function(xhr, status, args) {
                $this.currentStep = args.currentStep;
                
                if(!args.validationFailed) {
                    var currentStepIndex = $this.getStepIndex($this.currentStep);

                    if($this.cfg.showNavBar) {
                        if(currentStepIndex === $this.cfg.steps.length - 1) {
                            $this.hideNextNav();
                            $this.showBackNav();
                        } else if(currentStepIndex === 0) {
                            $this.hideBackNav();
                            $this.showNextNav();
                        } else {
                            $this.showBackNav();
                            $this.showNextNav();
                        }
                    }

                    //update step status
                    if($this.cfg.showStepStatus) {
                        $this.stepControls.removeClass('ui-state-highlight');
                        $($this.stepControls.get(currentStepIndex)).addClass('ui-state-highlight');
                    }
                }
            }
        };

        if(isBack) {
            options.params.push({name: this.id + '_backRequest', value: true});
        }

        PrimeFaces.ajax.Request.handle(options);
    },
    
    getStepIndex: function(step) {
        for(var i=0; i < this.cfg.steps.length; i++) {
            if(this.cfg.steps[i] == step)
                return i;
        }

        return -1;
    },
    
    showNextNav: function() {
        this.nextNav.fadeIn();
    },
    
    hideNextNav: function() {
        this.nextNav.fadeOut();
    },
    
    showBackNav: function() {
        this.backNav.fadeIn();
    },
    
    hideBackNav: function() {
        this.backNav.fadeOut();
    }
    
});
