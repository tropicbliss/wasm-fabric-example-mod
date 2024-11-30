cargo build --target wasm32-unknown-unknown --release
cp target/wasm32-unknown-unknown/release/rustbinding.wasm ../src/main/resources
