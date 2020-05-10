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
        feature {
            id = "anka-3"
            type = "CloudProfile"
            param("description", "")
            param("enabled", "true")
            param("image_name", "10.15.4")
            param("auth.cert.rootca", """
                -----BEGIN CERTIFICATE-----
                MIIDeDCCAmACCQD0gBLWR90xNjANBgkqhkiG9w0BAQsFADB+MQswCQYDVQQGEwJV
                UzERMA8GA1UECAwIVmlyZ2luaWExEzARBgNVBAcMCkJsYWNrc2J1cmcxEjAQBgNV
                BAoMCVZlZXJ0dUluYzEcMBoGA1UECwwTRGV2ZWxvcGVyIFJlbGF0aW9uczEVMBMG
                A1UEAwwMQW5rYSBSb290IENBMB4XDTIwMDUwNzIzMTYwOFoXDTIxMDUwNzIzMTYw
                OFowfjELMAkGA1UEBhMCVVMxETAPBgNVBAgMCFZpcmdpbmlhMRMwEQYDVQQHDApC
                bGFja3NidXJnMRIwEAYDVQQKDAlWZWVydHVJbmMxHDAaBgNVBAsME0RldmVsb3Bl
                ciBSZWxhdGlvbnMxFTATBgNVBAMMDEFua2EgUm9vdCBDQTCCASIwDQYJKoZIhvcN
                AQEBBQADggEPADCCAQoCggEBAJPMeVlEYYyoV21xAZ4PYbrGmPuYYWOXi+2lex2s
                +lVAT/QmgKOWf5hbUMosJYQeMK0dIICXlSmnuLaMNhD62nTRNNKQYLr9e5HN5sf+
                Ug+wxi7/mrICPoiZcP8Ng4qalAY1Vhs7QwvuyL2Z1H/LuC2KnwSbKVPNu7QuDxZ9
                5LADr9SqSjN1IHUdizAAqlv1IoliQbXFzd4ah2tt2TPMNq4qV3RitdsxTi6Qt5Oj
                vJEv8495V0ORwTUzlCwx6rO3flC55+nJWekwbixd66IDhhwCMq0p1Oa9WtB+mlMO
                YlaXfw/Jnp3iWizw/uHwbzf498gXVUmewIIXO/qShQPe44ECAwEAATANBgkqhkiG
                9w0BAQsFAAOCAQEAbYO2+4V0RD7sZ9WWVj/JITgl6g8iVo5DYUhgbb4mhL70sC27
                je0S5tnYbgRW5KEUqZBPY94rUoLzQ69YOq0wx87N9uwjIhd5MOGi9dNRG8lnPud1
                YrkWVD2IKtrjZLBB+TofYNTCd/Bq1d6DcuzwBNongciOdEyQUCCsWxq0zynKHmMF
                NpbCySLrcsie9L2qMElNurEeUtdsO+MWSWOpcA4BC+vvcN2uel2dMraKYO1hDTPM
                Gjyk4ee+FveG5J2e1bed/053/OBWyqByF+Jd6OcIG2fKJw/pJ/Pes3ehW+5l866R
                oVPycMAitsBFL1R1AUVWSf997Zb1rHVdR1XuSg==
                -----END CERTIFICATE-----
            """.trimIndent())
            param("agentPushPreset", "")
            param("auth.oidc.client_id", "")
            param("clouds.anka.url", "https://host.docker.internal:8090")
            param("image_tag", "base:port-forward-22:brew-git:openjdk-1.8.0_242:teamcity")
            param("agent_path", "/Users/anka/buildAgent")
            param("ssh_user", "anka")
            param("agentPoolId", "0")
            param("auth.cert.cert_key", """
                -----BEGIN RSA PRIVATE KEY-----
                MIIJJwIBAAKCAgEAoEcQ+IvybPWS7skEeI8HHa+7SQantLZsqSuceuO4U7u56oWe
                fOuOzX/fxZ7BQjmnhqHGt7ryp3LY/rNesgTLf77ncoJsGo5BjQpXdsJDMnuKwsAz
                AgFJMii/W5xuOAxDlgAT+RDJNS9eWTVEg8pwkz7VnOyLPShoPxmGmBPZio60EMZp
                pyGzlZ2R8QP7swjQkyQfLV2PQzks8I5Rfx/9n60a0VzegFDvgsJv26cW/fcko+gm
                zJlrKWdcCRNxNdYHrL7TDNQbtVgccH6R714I4l4GJjcoSBr+6P6Qq1IrVx40aUfS
                bK5PPnST7DW254PpwGaysGvj9iWXfX81IkJoXG9m0eViZx2YCgW1HSIkzssDgyhA
                INxYhmXRZGWwa5mYm5RvW7NCRKJjtd/PEVNnIOri66Sflu+wJ87FPlcR0vbDRlLX
                jaIXBW8WvB/7HueEMEDfjVvOr9w74lZDqOiLLeNOa8M2wh0wq7VwipFQCt6gL+Xn
                hcNmx9acJWgRzC10pCihEYTdmK6p9ifhkOQpKrgp6gybt78wyIPprrYJCezZcNVc
                +GOdC5al6tBejEM8g/iAw/UMTi4gL8heJNsBnfI5yQX7GhwsP0CCv7Aqw4+/XvlU
                B82mKaNr+CVnVUQFg+7Q8T9MBkF3VK60+la5GZbK+aRF90NgjJDxFq9qSbMCAwEA
                AQKCAgAeaT2UG2G1QOdPPX8GrQTJojVkBso9ZLu7YZYAT0MDSERfdlj7FOr0nQXF
                hnje6veZeQqug99U3FrGARy/pF9EbuGVfZ+rbkCL1WGBHB0J8B0FFNjY0Yuk48xj
                Qow7QEB2rq8bfA7hc4pwXMYSR5ASsEJx0wQcZ5VYG6zJIEMPokISSMN1PdTIV6yA
                UaQpdUu2D42G2xC6zZd0UVyvRU+nQ34qKXfiWvkHE4OL5ula6NDf9MWf3qBRq9Xv
                tuutLl4obdC3x2s2fnBu++UOyQXghbye9apD/DNP3DVw/FdS4V1KeKE5k91fWVlT
                4WFCDmqE4jeXd/E6HCnhWwim5njMfDNaCgmKtGYYOaI6d8QLrstPS/s37CASNAcm
                xNxlqTwXeRv2AMiq6pPtcepgErzW7DLrNTq1e9BLP9fgBRLGbLXdhaNLRNd0ZK0I
                URcymvpFKbOZY1RJJn08GYKbib3UPRCQ4xrsFqFYyU3bl3n/UvgxOXZ983WvHWYU
                95KROeBEbwe63L4mTfiPG4NQBqvQLc0iiwguaJ8igaS/5Eke8n0Kmk1uVie2tUrB
                G+tKTEoNHJ/FjGRwjYT6XBgq12tID4ac8F+rGq5eQhuEgi/HC4+SDB2XarHD3SO4
                m7NzcNGCmk7T6TUEjdzSt0LbKcXtxRYDG9/UHtjlU2PSQkiTUQKCAQEA1QLJYpVP
                uj44E023juF3ANj2fAvWvYMP0MI8qVadRqZK4QA43F9QoQ4EP2UsuY3YHKXeIP4r
                SpnlSW+dArKQqLxSHg0LGOvPzfMHNydf88+hTgT/aU8OOTb3KrtySPZgKidgmMRO
                amekLxDQwqTeFoPGGxOIpZuB067pg4cn5qLPu1idT7hrWkSxbBXbrtVw73nJ+i0j
                Z103a5/25++jX8sUltL7WC8By1S4YQNUnhtVFPUN6eOZIHBVGblz6ooGjN1ODGoI
                sMFjytmbKZuf9DMf6rMhnvM5UEeddmim46wwjygrcIoRszVFsTuAyBY7141IwC5E
                49UYK7GOd3+A2QKCAQEAwJ/QJ/rMyCYyDYc+K/edUMO3Hf+2UaSP7EI3HTBafP2K
                i+ChVN2QxUPS5gWs6SGdG9rdYOwoSzqiyHdgDJGVhzuMj4WgpuGwM7sqcDz4+7da
                94gpyu/ctKeGDTvla7xKPGYk2Dnvvp0mWdS0Hk7OD7O+o333rrF3UNL1FJSr95Hm
                jtYoJjgoSIpNkF52O5wCi+iWpmWS5/H4objLccQah/NjsJHsAdCM1Kd4FnQFMeBI
                1dELdLWGGGGa9rpz+A+tvKLwtmYyKpmCPwG3UUDcwrZa2ysWzZtQXYbD+kfNrwid
                oompQLAXNMdo2dOYoXNsJbpSLBt8Ig0GqR7jZXWHawKCAQALqW9lGk+XHrjrNaIL
                DIT7YuV7vRownfBLuZagnsFVkN0gnGaAiidb6eyJm/xq3D0stFgI7mFoYCyRbK7n
                6ubIlibYxlYJMz/ZQqjueBVkv8VRBC0HkvBwaXX2vPRw0ixJooZDVtwEL1Bp0z3a
                qjQOf4BlExi0GGNvN3BJZyjkE53T3/Ic3zfhZUlhZYD1fXIFamGIdNgvXIcgOU3H
                PPNw1yl1aG+iUFCE1UqS5R/I2C48S35Lg85qXDwMgH68JHpfU+5l95gqNSxFesxn
                5sFHGVVyAASjMyW8I2+Xf/tDE7ZE4Cogqy505UG/hkZyreTw1Cdbfiz/XDdKjRoD
                qNNhAoIBADl8uJvl7s3hEFkXPsfSa4HaF0F9uoTdLxLcpCQy9R6OcJXUYXG5emZV
                GpEJqpQdMw1IIX+2m0PwaPqZHfJCVLT6YbXHtK15d6PIvR6oI8rD6wMrAQYO1fiY
                cppqgMrJdAJYnbBmghWKQxLWNzdAX6EyDLgwdQYO8sQNYZVV1YjaY0vHwE2/vs3/
                cKygdHrP0ba9oJBiihhtD738L8NxOlXOnrbopd3Yxt8EaAOTdqVvAW3GqLuZHT8T
                ijMObGPhEgHVQy+8ikZKcCOruHEogXofADiewHx2WOLAwKZmXY1abek/WmLy6soW
                pUU1MD0m/GS6GaIORdrHtnAsxsLV86cCggEAXAmjYhKH87o3d79ijVj6U2JZkGo3
                3ZEw7Bo+mhoy0QGkRqou87Whu561V7PmZY1ZQWh7bGSPNQQihwtru6QGfIEPvGGi
                8UXEduEZTUhGdURy5d4515zZm1CZlOsgYEwrNT88wKStm218LpnvOjR8lC2ZWM3q
                0Pb98SDSvex2Q/e0Ml1+agXL/HSF4epoyjyRYYGCdigg4WJSpiifoNUokbuTq0cw
                +/1U8cWBZWMDRlLEUFlrOQXnMZdKK49TYBt0QMhjg5BnoNnwX86BXVzoQsubqR0X
                w/iVH9ESGDxrYC4jRvseq6TOBTz/r6rfZMZKPFa2mDBD/AaoB8qTNqXRaw==
                -----END RSA PRIVATE KEY-----
            """.trimIndent())
            param("auth.oidc.client_secret", "")
            param("profileServerUrl", "")
            param("total-work-time", "")
            param("auth.cert.cert", """
                -----BEGIN CERTIFICATE-----
                MIIEdTCCA10CCQCJ7Ei/xlKuWzANBgkqhkiG9w0BAQsFADB+MQswCQYDVQQGEwJV
                UzERMA8GA1UECAwIVmlyZ2luaWExEzARBgNVBAcMCkJsYWNrc2J1cmcxEjAQBgNV
                BAoMCVZlZXJ0dUluYzEcMBoGA1UECwwTRGV2ZWxvcGVyIFJlbGF0aW9uczEVMBMG
                A1UEAwwMQW5rYSBSb290IENBMB4XDTIwMDUxMDAwNDU0NloXDTIxMDUxMDAwNDU0
                NlowezELMAkGA1UEBhMCVVMxETAPBgNVBAgMCFZpcmdpbmlhMRMwEQYDVQQHDApC
                bGFja3NidXJnMRIwEAYDVQQKDAlWZWVydHVJbmMxHDAaBgNVBAsME0RldmVsb3Bl
                ciBSZWxhdGlvbnMxEjAQBgNVBAMMCVRlYW1jaXR5KTCCAiIwDQYJKoZIhvcNAQEB
                BQADggIPADCCAgoCggIBAKBHEPiL8mz1ku7JBHiPBx2vu0kGp7S2bKkrnHrjuFO7
                ueqFnnzrjs1/38WewUI5p4ahxre68qdy2P6zXrIEy3++53KCbBqOQY0KV3bCQzJ7
                isLAMwIBSTIov1ucbjgMQ5YAE/kQyTUvXlk1RIPKcJM+1Zzsiz0oaD8ZhpgT2YqO
                tBDGaachs5WdkfED+7MI0JMkHy1dj0M5LPCOUX8f/Z+tGtFc3oBQ74LCb9unFv33
                JKPoJsyZaylnXAkTcTXWB6y+0wzUG7VYHHB+ke9eCOJeBiY3KEga/uj+kKtSK1ce
                NGlH0myuTz50k+w1tueD6cBmsrBr4/Yll31/NSJCaFxvZtHlYmcdmAoFtR0iJM7L
                A4MoQCDcWIZl0WRlsGuZmJuUb1uzQkSiY7XfzxFTZyDq4uukn5bvsCfOxT5XEdL2
                w0ZS142iFwVvFrwf+x7nhDBA341bzq/cO+JWQ6joiy3jTmvDNsIdMKu1cIqRUAre
                oC/l54XDZsfWnCVoEcwtdKQooRGE3ZiuqfYn4ZDkKSq4KeoMm7e/MMiD6a62CQns
                2XDVXPhjnQuWperQXoxDPIP4gMP1DE4uIC/IXiTbAZ3yOckF+xocLD9Agr+wKsOP
                v175VAfNpimja/glZ1VEBYPu0PE/TAZBd1SutPpWuRmWyvmkRfdDYIyQ8Ravakmz
                AgMBAAEwDQYJKoZIhvcNAQELBQADggEBAEh6R+6SA7WOdfBrBrrtPjIC8HOkKnZV
                9kpab20YBoo7p3sh4We3DRUxJ3jyvoilItzRrudWF+n8FVTHiyYAL1swQ7ysfNTG
                TslHQ/O+S/+tmueSJ1lk9sH3PvZJFCBMaOn1WiGTfbSy62gNI823YfTs1WBHP0L/
                B2q3NwqOaRw4ptZ1z7kRZt6awB7G98viMAaFL3QBrqch7h8RaIbal9KaDQtN0+V0
                la29qXVyx+mBnsEFlcLMt3xV48Nuxy8ZnKh5QziubxWSX9R1Np6Xtg+XwJFEMf0S
                t0ebwlkePjxyn6P8CrmW17u0Y/FCGKhd2Csmh+pDPz6xxYx4EjIa2c0=
                -----END CERTIFICATE-----
            """.trimIndent())
            param("cloud-code", "anka")
            param("clouds.anka.maxInstances", "2")
            param("priority", "")
            param("terminate-after-build", "true")
            param("group_id", "")
            param("profileId", "anka-3")
            param("name", "Anka General Fleet")
            param("next-hour", "")
            param("image_id", "cfbf3554-1360-471a-8c5d-60620f17bae6")
            param("ssh_password", "admin")
            param("terminate-idle-time", "30")
            param("auth.method", "cert")
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
                sleep 3
                echo "Done!"
            """.trimIndent()
        }
        script {
            name = "Test"
            enabled = false
            scriptContent = """
                echo "Testing..."
                [[ -z ${'$'}something ]] && echo "something is empty!" && exit 1
                echo "something found: ${'$'}something"
                echo "Tests complete!"
            """.trimIndent()
        }
        script {
            name = "Cleanup"
            enabled = false
            executionMode = BuildStep.ExecutionMode.ALWAYS
            scriptContent = """
                echo "Cleaning up"
                echo "Cleaned up!"
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }
})

object TeamcityExamples_HttpsGithubComVeertuincTeamcityExamplesRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/veertuinc/teamcity-examples#refs/heads/master"
    url = "https://github.com/veertuinc/teamcity-examples"
})
