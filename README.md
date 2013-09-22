gradle-atg
==========

<p>ATG Gradle tasks conceptual definition</p>

- To build (optional, not required for P1, P2 tasks, but required for P3): gradle
- To test P1 tasks: gradle -b atg-1.gradle [startSQLRepository (only if server and jdbc driver setup) runAssembler]
- To test P2 tasks: gradle -b atg-2.gradle runAssembler
- To test P3 tasks: gradle -b atg-3.gradle runAssembler

<h3>Configuration</h3>
Build configuration is applied in the following sequence allowing various overrides:
- build configuration in buildtools/task-config.gradle using ext vars only
- project specific config override buildtools/project-config.gradle
- user global (across multiple gradle projects) $HOME/.gradle.user-config.gradle
- user local (final user level override) <project>/user-config.gradle (an ignored file)

<h3>Phase 1: Tasks written directly in build file</h3>
- runAssembler (limited) (type: Exec)
- startSQLRepository
-- (TODO) Requires an ATG server already configured and a Module configured that points to the JDBC driver in the gradle cache in its manifest.

<h3>Phase 2: Extend gradle Exec types for additional properties in buildSrc</h3>
- runAssembler (limited) (type: RunAssembler->Exec)

<h3>Phase 3: Move to custom plugin mechanism for multi-project re-use</h3>
- Added settings.gradle to include ATGPlugin project
- Added plugins sub-dir with ATGPlugin sub-project
- Note: Renamed buildSrc to buildSrcOld to remove conflicting classes for this exercise.
- Added pluginRepo for interim local Maven repo for build upload and use
