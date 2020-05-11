import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.buildReportTab
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {
    description = "Contains all other projects"

    features {
        buildReportTab {
            id = "PROJECT_EXT_1"
            title = "Code Coverage"
            startPage = "coverage.zip!index.html"
        }
    }

    cleanup {
        baseRule {
            preventDependencyCleanup = false
        }
    }

    subProject(TeamcityExamples)
}


object TeamcityExamples : Project({
    name = "Teamcity Examples"

    vcsRoot(TeamcityExamples_HttpsGithubComVeertuincTeamcityExamplesRefsHeadsMaster)

    buildType(TeamcityExamples_Build)
})

object TeamcityExamples_Build : BuildType({
    name = "Pipeline"

    vcs {
        root(TeamcityExamples_HttpsGithubComVeertuincTeamcityExamplesRefsHeadsMaster)
    }

    steps {
        script {
            name = "Preparation"
            scriptContent = """
                echo "Testing from ${'$'}(hostname)"
                env
                uname -a
                export something="blah"
            """.trimIndent()
        }
        script {
            name = "Build"
            scriptContent = """
                echo "Building..."
                ls -laht
                sleep 20
                echo "Done!"
            """.trimIndent()
        }
        script {
            name = "Test"
            scriptContent = """
                echo "Testing..."
                sleep 10
                echo "Tests complete!"
            """.trimIndent()
        }
        script {
            name = "Cleanup"
            executionMode = BuildStep.ExecutionMode.ALWAYS
            scriptContent = """
                echo "Cleaning up"
                echo "Cleaned up!"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
            enabled = false
        }
    }
})

object TeamcityExamples_HttpsGithubComVeertuincTeamcityExamplesRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/veertuinc/teamcity-examples#refs/heads/master"
    url = "https://github.com/veertuinc/teamcity-examples"
})
