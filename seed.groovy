folder('CI-Pipelines') {
    displayName('CI Pipelines')
    description('CI Pipelines')
}
pipelineJob('frontend') {
    configure { flowdefinition ->
        flowdefinition << delegate. 'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
            'scm'(class:'hudson.plugin.git.GitSCM',plugin:'git') {
                'userRemoteConfigs' {
                    'hudson.plugin.git.UserRemoteConfig' {
                        'url'('https://github.com/chandra-zs/frontend.git')
                    }
                }
                'branches' {
                    'hudson.plugin.git.BranchSpec' {
                        'name'('*/main')
                    }
                }
            }
            'scriptPath'('Jenkinsfile')
            'lightweight'(true)
        }
    }
}