gradle-atg
==========

<p>ATG Gradle tasks conceptual definition</p>

- To build: gradle
- To test P1 tasks: gradle -b atg.gradle [startSQLRepository runAssembler]

<h3>Configuration</h2>
Build configuration is applied in the following sequence allowing various overrides:
- build configuration in buildtools/task-config.gradle using ext vars only
- project specific config override buildtools/project-config.gradle
- user global (across multiple gradle projects) $HOME/.gradle.user-config.gradle
- user local (final user level override) <project>/user-config.gradle (an ignored file)

<h3>Phase 1: Tasks written directly in build file</h3>
- runAssembler
- startSQLRepository
-- (TODO) Requires an ATG server already configured and a Module configured that points to the JDBC driver in the gradle cache in its manifest.

<h3>Phase 2: Extend gradle Exec types for additional properties in buildSrc</h3>

<h3>Phase 3: Move to custom plugin mechanism for multi-project re-use</h3>
