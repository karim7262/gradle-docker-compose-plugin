package com.avast.gradle.dockercompose.tasks

import com.avast.gradle.dockercompose.ComposeSettings
import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

@CompileStatic
class ComposeBuild extends DefaultTask {

    @Internal
    ComposeSettings settings

    ComposeBuild() {
        group = 'docker'
        description = 'Builds images for services of docker-compose project'
    }

    @TaskAction
    void build() {
        String[] args = ['build']
        args += (List<String>)settings.buildAdditionalArgs.get()
        args += (List<String>)settings.startedServices.get()
        settings.composeExecutor.execute(args)
    }
}
